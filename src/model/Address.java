package model;

public class Address {

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
		return "Address [street=" + street + ", streetNum=" + streetNum + ", city=" + city + ", country=" + country
				+ "]";
	}
	
	public String adressForDisplay() {
		return street + " " + streetNum + ", " + city + ", " + country;
	}

	
	
	
}
