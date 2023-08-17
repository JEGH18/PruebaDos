package model;

public class Book {

	private String id;
	private String name;
	private double price;
	private int unitsSold;

	public Book(String id, String name, double price) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.unitsSold = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

}
