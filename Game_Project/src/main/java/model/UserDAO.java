package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.*;

public enum UserDAO {
	instance;
	List<User> users;
	
	private UserDAO(){
		users = new ArrayList<User>();
	}
	
	public Connection getConnection() throws Exception {
	    Class.forName("org.hsqldb.jdbcDriver");
	    Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
	    return con;
	}
	
	public List<User> list() throws Exception{
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM user");
		
		while (rs.next()) {
			String name = rs.getString("name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String address = rs.getString("address");
			User u = new User(name, email, password, address);
			users.add(u);
		}
	return users;
	}
	
	public void saveUser(User user) throws Exception {
	    List<User> users = list();
	    User userInput = new User(user.getName(), user.getEmail(), user.getPassword(), user.getAddress());

	    for (int i = 0; i < users.size(); i++) {
	        User userDB = users.get(i);

	        if (userDB.equals(userInput)) {
	            System.out.println("User already exists!");
	            return;
	        }
	    }

	    // If the loop completes and no matching user is found, add the new user to the database
	    Connection con = getConnection();
	    System.out.println("Connection done");

	    try (PreparedStatement pstmt = con.prepareStatement(
	            "INSERT INTO user(name, email, password, address) VALUES (?, ?, ?, ?)")) {
	        System.out.println("Query ran");

	        pstmt.setString(1, user.getName());
	        pstmt.setString(2, user.getEmail());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getAddress());

	        pstmt.executeUpdate();
	        System.out.println("User added to the database");
	    }
	}

	
	public boolean checkLogin(String email, String password) throws Exception {
		boolean loginRes = false;
		List<User> ul =list();
		System.out.println("size: " + ul.size());
		for (int i = 0; i < ul.size(); i++) {
			System.out.println(ul.get(i).getName());
			//User u = users.get(i);
			if (ul.get(i).getEmail().equals(email) && ul.get(i).getPassword().equals(password)) {
				System.out.println("user is here");
				loginRes = true;
				break;
			}else {
			}
		}
		return loginRes;
	}
	
	public User select(String email, String password) throws Exception {
		Connection con = getConnection();
		System.out.println("connection done");
		
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT* FROM USER WHERE EMAIL = '"+email+ "'");
		while (rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
		User uDB = new User(name, email, password, address);
			System.out.println("Name: " + name );
			return uDB;

		}
		}catch(Exception e) {
			System.out.println("fail to get user details");
			return null;

		}
		return null;
	}
	
	public void updateUser(User u, String n) throws Exception {
	    Connection con = getConnection();
	    try {
	        String sql = "UPDATE USER SET NAME=?, EMAIL=?, ADDRESS=?, PASSWORD=? WHERE NAME=?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, u.getName());
	            pstmt.setString(2, u.getEmail());
	            pstmt.setString(3, u.getAddress());
	            pstmt.setString(4, u.getPassword());
	            pstmt.setString(5, n); 

	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("User updated successfully");
	            } else {
	                System.out.println("User not found or not updated");
	            }
	        }
	    } finally {
	        // Close resources (Connection, PreparedStatement, etc.) in a finally block
	        if (con != null) {
	            con.close();
	        }
	    }
	}
	
	public void deleteUser(String userName) throws Exception {
	    Connection con = getConnection();

	    try {
	        String sql = "DELETE FROM USER WHERE NAME=?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, userName);

	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("User deleted successfully");
	            } else {
	                System.out.println("User not found or not deleted");
	            }
	        }
	    } finally {
	        // Close resources (Connection, PreparedStatement, etc.) in a finally block
	        if (con != null) {
	            con.close();
	        }
	    }
	}


	
}
