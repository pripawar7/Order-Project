package com.as.order.domain;

import java.util.ArrayList;

import com.as.order.domain.Customer;
import com.as.order.domain.OrderItem;
import com.as.order.domain.Product;

public class Order {
	
	private String code;
	private Customer customer;
	private ArrayList<OrderItem> order;
	private double subTotal;
	private double tax;
	private double total;
	
	public Order(String code, Customer customer) {
		this.code = code;
		this.customer = customer;
		order = new ArrayList<OrderItem>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<OrderItem> order) {
		this.order = order;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void addItem(OrderItem item){
		
		if(order.isEmpty()){
			order.add(item);
			subTotal = item.getQuantity() * item.getProduct().getPrice();
		}else{
			for(OrderItem e: order){
				if(e.getProduct().equals(item.getProduct())){
					int quantity = e.getQuantity() + item.getQuantity();
					e.setQuantity(quantity);
					subTotal = quantity * e.getProduct().getPrice();
				}
				else{
					order.add(item);
					subTotal += item.getQuantity() * item.getProduct().getPrice();
					break;
				}
			}
		}
		
	}
	
	public void removeProduct(Product prod){
		for(OrderItem e: order){
			if(e.getProduct().getProductName().equals(prod.getProductName())){
				order.remove(e);
			}
			break;
		}
	}

}
