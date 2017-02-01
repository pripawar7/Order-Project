package com.as.order.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.as.order.domain.Customer;
import com.as.order.domain.Order;
import com.as.order.domain.OrderItem;
import com.as.order.domain.Product;
import com.as.order.services.TaxServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ExampleConfigurationTests-context.xml")
public class TaxServicesTest {
	@Autowired
	@Qualifier("salesTaxServices")
	private TaxServices salesTax;
	@Autowired
	@Qualifier("vatTaxServices")
	private TaxServices vatTax;
	
	private Order order;
	private OrderItem orderItem;
	private Customer cust;
	private Product product;

	@Before
	public void setUp() throws Exception {
		cust = new Customer("Anuj", "NJ");
		order = new Order("CS-1610", cust);
		product = new Product("Toast", 72);
		orderItem = new OrderItem(product, 3);
		
	}

	@Test
	public void testComputeSalesTax(){
		order.addItem(orderItem);
		double actualTax = salesTax.computeTax(order);
		
		double expectedTax = order.getTax();
		
		assertEquals(expectedTax, actualTax);		
		
	}

}
