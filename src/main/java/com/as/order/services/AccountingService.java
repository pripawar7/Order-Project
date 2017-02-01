package com.as.order.services;
import com.as.order.domain.*;

public interface AccountingService {
	public void recordNewOrder(Order order);
	public double computeTax(Order order);
}
