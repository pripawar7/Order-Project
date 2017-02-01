package com.as.order.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.as.order.domain.Customer;
import com.as.order.domain.Order;
import com.as.order.domain.OrderItem;
import com.as.order.domain.Product;


public class OrderAndOrderItemTest {

	private Order order;
	private OrderItem orderItem;
	private Customer cust;
	private Product product;
	

	@Before
	public void setUp() throws Exception {
		cust = new Customer("Anuj", "NJ");
		order = new Order("CS-1610", cust);
		product = new Product("Toast", 60);
		orderItem = new OrderItem(product, 3);
	}

	@Test
	public void testAddOrRemoveOrderItem() {
		int orderCount = order.getOrder().size();

		order.addItem(orderItem);
		order.addItem(orderItem);

		int newOrderCount = order.getOrder().size();

		assertEquals(orderCount + 1, newOrderCount);

		Product tempProduct = new Product("teeshirt", 22);
		OrderItem tempOrderItem = new OrderItem(tempProduct, 3);
		order.addItem(tempOrderItem);

		newOrderCount = order.getOrder().size();

		assertEquals(orderCount + 2, newOrderCount);

		order.removeProduct(product);

		newOrderCount = order.getOrder().size();

		assertEquals(orderCount + 1, newOrderCount);
	}
	

}
