package model;

public class Game {
	private int game_id;
	private String user_name;
	private String title;
	private String genre;
	
	public Game(int game_id2, String user_name, String title, String genre) {
		this.game_id = game_id2;
		this.user_name = user_name;
		this.title = title;
		this.genre = genre;
	}

	public Game(String user_name, String title, String genre) {
		this.user_name = user_name;
		this.title = title;
		this.genre = genre;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
