package com.tcs.bean;

import java.util.List;

public class ItemResponse {
	
	private String status;
	private String message;
	private List<Item> items;

	public ItemResponse() {
		super();
	}

	public ItemResponse(String status, String message, List<Item> items) {
		super();
		this.status = status;
		this.message = message;
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
