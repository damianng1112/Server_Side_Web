package model;

public class House {
	private String owner;
	private String address;
	private String numOfBedrooms;
	
	public House(String owner, String address, String numOfBedrooms) {
		super();
		this.owner = owner;
		this.address = address;
		this.numOfBedrooms = numOfBedrooms;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumOfBedrooms() {
		return numOfBedrooms;
	}

	public void setNumOfBedrooms(String numOfBedrooms) {
		this.numOfBedrooms = numOfBedrooms;
	}
	
}
