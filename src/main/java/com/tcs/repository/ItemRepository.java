package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.bean.Item;

public interface ItemRepository extends CrudRepository<Item, Integer>{

}
