package com.as.order.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.as.order.domain.*;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
	
	private Map<String, Integer> currentInventory;
	
	@PostConstruct
	public void initInventory(){
		currentInventory = new HashMap<String, Integer>();
		currentInventory.put("Toast",20);
		currentInventory.put("Butter",20);
		currentInventory.put("Bottom",20);
	}

	public void adjustInventory(Order order) {
		ArrayList<OrderItem> orderitems = order.getOrder();
		Product product;
		int qty;
		int totalQuantity;
		
		for(OrderItem orderitm : orderitems){
			product=orderitm.getProduct();
			qty=orderitm.getQuantity();
			totalQuantity=currentInventory.get(product.getProductName())-qty;
			currentInventory.put(product.getProductName(), totalQuantity);
		
		}

	}
	
	public void printInventory() {
		System.out.println("");
		//iterating using keyset()
		  for(String key : currentInventory.keySet()){
			  System.out.println(key + " Available:"+ currentInventory.get(key));
		  }
	}

}
