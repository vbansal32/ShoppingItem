package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.bean.Item;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	List<Item> items = new ArrayList<Item>();
	
	public ItemController() {
		Item item1 = new Item("item1", "First Item", "Google", true, 4.7f);
		Item item2 = new Item("item2", "Second Item", "Amazon", false, 4.3f);
		Item item3 = new Item("item3", "Third Item", "MRF", true, 3.9f);
		Item item4 = new Item("item4", "Fourth Item", "Michilen", false, 4.5f);
		this.items.add(item1);
		this.items.add(item2);
		this.items.add(item3);
		this.items.add(item4);
	}
	
	@RequestMapping(value="/getItem/{itemId}", produces = "application/json", method = RequestMethod.GET)
	public Item getItem(@PathVariable("itemId") String itemId) {
		Item item = null;
		for (Item i : items) {
			if(i.getItemId().equalsIgnoreCase(itemId)) {
				item=i;
				break;
			}
		}
		System.out.println("itemId= " + itemId);
		return item;
	}
	
	@RequestMapping(value="/getAllItems", produces = "application/json", method = RequestMethod.GET)
	public List<Item> getAllItems() {
		return items;
	}
	
	@RequestMapping(value="/addItem", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Item addItem(@RequestBody String itemString) throws JsonParseException, JsonMappingException, IOException {
		Item item = new ObjectMapper().readValue(itemString, Item.class);
		this.items.add(item);
		System.out.println(item.toString());
		System.out.println(this.items.size());
		return item;
	}

}
