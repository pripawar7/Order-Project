package com.as.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.as.order.domain.*;

@Service("orderProcessor")
public class OrderProcessor {
	
	@Autowired
	@Qualifier("acctService")
	private AccountingService acctService;
	
	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}
	
	public OrderProcessor() {
	}
	
	public void newOrder(Order order) {
		double tax=acctService.computeTax(order);
		order.setTax(tax);
		double subtotal=order.getSubTotal();
		double total=subtotal + tax;
		order.setTotal(total);
		
		acctService.recordNewOrder(order);
		printOrder(order);
		System.out.println("SubTotal:     "+subtotal);
		System.out.println("Tax:          "+tax);
		System.out.println("              "+"-------");
		System.out.println("Total Amount: "+total);
	}
	
	public void printOrder(Order order){
		Product product;
		Customer cust = order.getCustomer();
		System.out.println("Order Code:    "+order.getCode());
		System.out.println("Customer Name: "+ cust.getName());
		System.out.println("State:         "+cust.getState());
		System.out.println("");
		for(OrderItem oI : order.getOrder()){
			product = oI.getProduct();
			System.out.println("Product Name: "+ product.getProductName());
			System.out.println("Price:        "+ product.getPrice());
			System.out.println("Quantity:     "+ oI.getQuantity());
			System.out.println("");
		}
	}
}