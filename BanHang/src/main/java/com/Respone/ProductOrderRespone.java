package com.Respone;

import org.springframework.stereotype.Component;

import com.DTO.ProductDTO;

@Component
public class ProductOrderRespone {
	private ProductDTO proDTO;
	private int quantity;
	
	
	public ProductDTO getProDTO() {
		return proDTO;
	}
	public void setProDTO(ProductDTO proDTO) {
		this.proDTO = proDTO;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
