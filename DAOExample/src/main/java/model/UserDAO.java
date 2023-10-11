package model;
import java.util.ArrayList;
import java.util.List;

public enum UserDAO {
	instance;
	List<User> users;
	
	private UserDAO() {
		
		users = new ArrayList<User>();
		
		User u1 = new User("Mary", "Galway");
		User u2 = new User("John", "Longford");
		User u3 = new User("Ivan", "Athlone");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);		
	}
	public List<User> list(){
		return this.users;
	}
}
