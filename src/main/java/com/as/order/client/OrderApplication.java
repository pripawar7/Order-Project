package com.as.order.client;
import com.as.order.domain.*;
import com.as.order.services.InventoryService;
import com.as.order.services.OrderProcessor;


import org.springframework.context.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main(String args[]) {
		ApplicationContext container = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/app-context.xml");
		
		Order order;
		Customer cust;
		Product product;
		OrderItem orderItem;
		
		OrderProcessor orderProc = (OrderProcessor) container.getBean("orderProcessor");
		InventoryService invServices = (InventoryService) container.getBean("inventoryService");
		
		cust = new Customer("Anuj", "CA");
	 	order = new Order("Cus-1610",cust);
	
	 	
	 	product = new Product("Toast", 62);//Add prod
	 	orderItem = new OrderItem(product, 3);
	 	order.addItem(orderItem);
	 	
	 	Product tempProd = new Product("Test", 21.00);
		
		order.removeProduct(tempProd);
	 	
	 	product = new Product("Butter", 40);
	 	orderItem = new OrderItem(product, 5);
	 	order.addItem(orderItem);
	 	
	 	product = new Product("Bottom", 100);
	 	orderItem = new OrderItem(product, 2);
	 	order.addItem(orderItem);
	 	
	 	invServices.printInventory();
	 	orderProc.newOrder(order);
	 	invServices.adjustInventory(order);
	 	invServices.printInventory();
	 	((AbstractApplicationContext) container).close();
	}
}
