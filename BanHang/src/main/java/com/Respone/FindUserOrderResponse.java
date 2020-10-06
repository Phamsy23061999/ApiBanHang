package com.Respone;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FindUserOrderResponse {
	

	
	private List<ProductOrderRespone> Order;
	
	private int totalPrice;
	
	

	

	public List<ProductOrderRespone> getOrder() {
		return Order;
	}

	public void setOrder(List<ProductOrderRespone> order) {
		Order = order;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
