package com.as.order.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.as.order.domain.Order;

@Service("salesTaxServices")
public class ComputeSalesTax implements TaxServices {
	
	@Value("#{stateSalesTax}")
	private Map stateSalesTax;
	
	
	public Map getStateSalesTax() {
		return stateSalesTax;
	}


	public void setStateSalesTax(Map stateSalesTax) {
		this.stateSalesTax = stateSalesTax;
	}


	public double computeTax(Order order) {
		double percent =Double.parseDouble((String)stateSalesTax.get(order.getCustomer().getState()));
		double salesTax = order.getSubTotal() * (percent/100);
		double totalTax=order.getTax()+salesTax;
		order.setTax(totalTax);
		return salesTax;
	}

}
