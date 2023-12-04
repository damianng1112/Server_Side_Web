package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public enum GameDAO {
	instance;
	List<Game> games;
	
	private GameDAO() {
		games = new ArrayList<Game>();
	}
	
	public Connection getConnection() throws Exception {
	    Class.forName("org.hsqldb.jdbcDriver");
	    Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
	    return con;
	}
	
	public List<Game> list() throws Exception{
		Connection con = getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM game");
			
			while (rs.next()) {
				int game_id = rs.getInt("game_id");
				String user_name = rs.getString("user_name");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				Game g = new Game(game_id, user_name, title, genre);
				games.add(g);
			}
		} finally {
	        if (con != null) {
	            con.close();
	        }
	    }
		return games;
	}
	
	public List<Game> listByUser(User user) throws Exception {
	    Connection con = getConnection();
	    List<Game> userGames = new ArrayList<>();

	    try {
	        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game WHERE user_name = ?");
	        pstmt.setString(1, user.getName());
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int gameId = rs.getInt("game_id");
	            String title = rs.getString("title");
	            String genre = rs.getString("genre");

	            Game game = new Game(gameId, user.getName(), title, genre);
	            userGames.add(game);
	        }
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }

	    return userGames;
	}
	
	public boolean hasUserPlayedGame(String userName, String title) throws Exception {
	    Connection con = getConnection();
	    try {
	        PreparedStatement pstmt = con.prepareStatement(
	            "SELECT * FROM game WHERE user_name = ? AND title = ?");
	        pstmt.setString(1, userName);
	        pstmt.setString(2, title);

	        ResultSet rs = pstmt.executeQuery();
	        return rs.next(); // If a row is returned, the user has played the game
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }
	}

	public void saveGame(Game game) throws Exception {
	    if (hasUserPlayedGame(game.getUser_name(), game.getTitle())) {
	        System.out.println("User already played this game!!");
	        return; // Do not add the game if the user has already played it
	    }

	    Connection con = getConnection();
	    try {
	        PreparedStatement pstmt = con.prepareStatement(
	            "INSERT INTO game(user_name, title, genre) VALUES (?, ?, ?)");
	        pstmt.setString(1, game.getUser_name());
	        pstmt.setString(2, game.getTitle());
	        pstmt.setString(3, game.getGenre());

	        pstmt.executeUpdate();
	        System.out.println("Game added to the database");
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }
	}
	
	public void updateGame(Game game) throws Exception {
	    Connection con = getConnection();
	    
	    try {
	        PreparedStatement pstmt = con.prepareStatement(
	            "UPDATE game SET title=?, genre=? WHERE game_id=?");
	        pstmt.setString(1, game.getTitle());
	        pstmt.setString(2, game.getGenre());
	        pstmt.setInt(3, game.getGame_id());

	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Game updated successfully");
	        } else {
	            System.out.println("Game not found or not updated");
	        }
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }
	}

	public void deleteGame(int game_id) throws Exception {
	    Connection con = getConnection();

	    try {
	        PreparedStatement pstmt = con.prepareStatement("DELETE FROM game WHERE game_id=?");
	        pstmt.setInt(1, game_id);

	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Game deleted successfully");
	        } else {
	            System.out.println("Game not found or not deleted");
	        }
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }
	}

}

