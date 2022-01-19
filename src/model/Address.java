package model;

public class Address {

	private int id;
	private String street;
	private String streetNum;
	private String city;
	private String country;
	
	public Address() {
		super();
	}
	
	
	public Address(String street, String streetNum, String city, String country) {
		super();
		this.street = street;
		this.streetNum = streetNum;
		this.city = city;
		this.country = country;
	}


	public Address(int id, String street, String streetNum, String city, String country) {
		super();
		this.id = id;
		this.street = street;
		this.streetNum = streetNum;
		this.city = city;
		this.country = country;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return  street + ", " + streetNum + ", " + city + ", " + country;
	}
	
	public String adressForDisplay() {
		return street + " " + streetNum + ", " + city + ", " + country;
	}

	
	
	
}
