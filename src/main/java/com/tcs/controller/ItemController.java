package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.bean.Item;
import com.tcs.bean.ItemResponse;
import com.tcs.service.ItemService;
import com.tcs.utility.ItemConstants;

@RestController
@RequestMapping("/item")
public class ItemController implements ItemConstants {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	ItemService itemService;
	
	ItemResponse itemResponse;
	
	@GetMapping(value="/getItem/{itemId}", produces = "application/json")
	public ItemResponse getItembyId(@PathVariable("itemId") int itemId) {
		itemResponse = context.getBean(ItemResponse.class);
		List<Item> items = new ArrayList<>();
		items.add(itemService.findItemById(itemId));
		itemResponse.setItems(items);
		return itemResponse;
	}
	
	@GetMapping(value="/getAllItems", produces = "application/json")
	public ItemResponse getAllItems() {
		itemResponse = context.getBean(ItemResponse.class);
		itemResponse.setItems(itemService.findAllItems());
		return itemResponse;
	}
	
	@PostMapping(value="/addItem", consumes = "application/json", produces = "application/json")
	public ItemResponse addItem(@RequestBody String itemString) {
		itemResponse = context.getBean(ItemResponse.class);
		try {
			Item item = new ObjectMapper().readValue(itemString, Item.class);
			itemService.addItem(item);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return itemResponse;
	}
	
	@PostMapping(value="/updateItem", consumes = "application/json", produces = "application/json")
	public ItemResponse updateItem(@RequestBody String itemString){
		itemResponse = context.getBean(ItemResponse.class);
		try {
			Item item = new ObjectMapper().readValue(itemString, Item.class);
			itemService.updateItem(item);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return itemResponse;
	}

}
