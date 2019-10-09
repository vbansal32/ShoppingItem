package com.tcs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bean.Item;
import com.tcs.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	private List<Item> items = new ArrayList<>(Arrays.asList(
			new Item(1, "First Item", "MRF", 45, 3.9f),
			new Item(1, "Second Item", "Michilen", 7, 4.1f),
			new Item(1, "Third Item", "Bridgestone", 2, 4.9f),
			new Item(1, "Fourth Item", "TVS", 1020, 2.7f)
			));
	
	public List<Item> findAllItems(){
		List<Item> allItems= new ArrayList<>();
		itemRepository.findAll().forEach(allItems::add);
		return allItems;
	}
	
	public Item findItemById(int itemId){
		return itemRepository.findById(itemId).orElse(null);
	}
	
	public void addItem(Item item){
		itemRepository.save(item);
	}
	
	public void updateItem(Item item){
		itemRepository.save(item);
	}
	public void deleteItem(int itemId){
		itemRepository.deleteById(itemId);
	}
	
	public List<Item> getAllItems() {
		return items;		
	}
	
	public Item getItemById(int itemId) {
		return items.stream().filter(item -> item.getItemId()==itemId).findFirst().orElse(null);	
	}
	
}
