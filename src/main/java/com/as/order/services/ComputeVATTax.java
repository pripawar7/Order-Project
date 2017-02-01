package com.as.order.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.as.order.domain.Order;

@Service("vatTaxServices")
public class ComputeVATTax implements TaxServices {
	
	//@Value("#{stateVATTax}")
	private Map stateVATTax;
	
	
	public Map getStateVATTax() {
		return stateVATTax;
	}


	public void setStateVATTax(Map stateVATTax) {
		this.stateVATTax = stateVATTax;
	}


	public double computeTax(Order order) {
		double percent =Double.parseDouble((String)stateVATTax.get(order.getCustomer().getState()));
		double vatTax = order.getSubTotal() * (percent/100);
		double totalTax=order.getTax()+vatTax;
		order.setTax(totalTax);
		return vatTax;
	}

}
