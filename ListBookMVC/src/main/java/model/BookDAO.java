package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum BookDAO {
	instance;
	List<Book> books;
	
	private BookDAO() {
		
		books = new ArrayList<Book>();
		
		Book u1 = new Book("WWE", "Faithful");
		Book u2 = new Book("Getting good mustache", "Ronan");
		Book u3 = new Book("Design", "Natalia");
		
		books.add(u1);
		books.add(u2);
		books.add(u3);		
	}
	public List<Book> list(){
		return this.books;
	}
	
	public void save (Book b) {
		Iterator<Book> a = books.iterator();
		while(a.hasNext()) {
			if (b.equals(a)) {
				
			}else {
				books.add(b);
			}
		}
	}
}

