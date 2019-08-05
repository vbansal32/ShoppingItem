package com.tcs.bean;

public class Item {

	private String itemId;
	private String itemDescription;
	private String manufacturar;
	private boolean availability;
	private float rating;
	
	public Item() {
		super();
	}
	
	public Item(String itemId, String itemDescription, String manufacturar, boolean availability, float rating) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.manufacturar = manufacturar;
		this.availability = availability;
		this.rating = rating;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getManufacturar() {
		return manufacturar;
	}
	public void setManufacturar(String manufacturar) {
		this.manufacturar = manufacturar;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return itemId + " " + itemDescription + " " + manufacturar + " " + availability + " " + rating;
	}
}
