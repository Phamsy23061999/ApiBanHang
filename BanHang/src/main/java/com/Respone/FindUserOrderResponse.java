package com.Respone;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FindUserOrderResponse {
	
	private List<ProductOrderRespone> listOrder;
	
	private int totalPrice;

	public List<ProductOrderRespone> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<ProductOrderRespone> listOrder) {
		this.listOrder = listOrder;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
