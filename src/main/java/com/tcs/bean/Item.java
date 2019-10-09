package com.tcs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SITEM")
public class Item {

	@Id
	@Column(name="ITEM_ID")
	private int itemId;
	@Column(name="X_DESC")
	private String itemDescription;
	@Column(name="MNFACTR")
	private String manufacturar;
	@Column(name="I_QTY")
	private int availableQuantity;
	@Column(name="RATING")
	private float rating;
	
	public Item() {
		super();
	}
	public Item(int itemId, String itemDescription, String manufacturar, int availableQuantity, float rating) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.manufacturar = manufacturar;
		this.availableQuantity = availableQuantity;
		this.rating = rating;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
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

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	

	@Override
	public String toString() {
		return itemId + " " + itemDescription + " " + manufacturar + " " + availableQuantity + " " + rating;
	}
}
