package com.as.order.services;
import com.as.order.domain.*;

public interface BillingService {
	public void billCustomer(Customer cus, Order order);
}
