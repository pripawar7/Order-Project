package com.as.order.services;
import com.as.order.domain.*;

public interface InventoryService {
	public void adjustInventory(Order order);
	public void printInventory();
}
