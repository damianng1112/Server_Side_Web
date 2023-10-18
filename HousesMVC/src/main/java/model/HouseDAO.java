package model;
import java.util.ArrayList;
import java.util.List;

public enum HouseDAO {
	instance;
	List<House> houses;
	
	private HouseDAO() {
		
		houses = new ArrayList<House>();
		
		House h1 = new House("Damian", "Willow Park", "2");
		House h2 = new House("Faithful", "Glenn", "1");
		House h3 = new House("Martina", "Not Athlone", "3");
		
		houses.add(h1);
		houses.add(h2);
		houses.add(h3);		
	}
	public List<House> list(){
		return this.houses;
	}
	
	public void save (House h) {
		if (h.getOwner()==null) {
			h.setOwner("name unknown");
		}
		if (h.getAddress()==null) {
			h.setAddress("address unknown");
		}
		if (h.getNumOfBedrooms()=="") {
			h.setNumOfBedrooms("0");
		}
		houses.add(h);
	}
}
