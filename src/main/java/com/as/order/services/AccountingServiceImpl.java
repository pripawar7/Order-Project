package com.as.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.as.order.domain.Order;

@Service("acctService")
public class AccountingServiceImpl implements AccountingService {
	
	@Autowired
	
	
	@Qualifier("salesTaxServices")
	private TaxServices taxServices;
	
	public TaxServices getTaxServices() {
		return taxServices;
	}

	public void setTaxServices(TaxServices taxServices) {
		this.taxServices = taxServices;
	}
	
	public void recordNewOrder(Order order) {
		System.out.println("New Order Processed...***");
		System.out.println("");
	}

	public double computeTax(Order order) {
		return  taxServices.computeTax(order);
	}

}
