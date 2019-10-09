package com.tcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tcs.bean.ItemResponse;

@Configuration
public class ItemConfig {
	@Bean
	@Scope("prototype")
	public ItemResponse getItemResponse() {
		return new ItemResponse();
	}
}
