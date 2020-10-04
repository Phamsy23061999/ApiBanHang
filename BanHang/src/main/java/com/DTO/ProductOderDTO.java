package com.DTO;

import javax.persistence.Column;
import javax.persistence.Embedded;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Category;
import com.model.ProductOder;
import com.model.Embeddalbe.ProductOderEmbeddable;

public class ProductOderDTO {
	

	private int productId;
	
	private int oderId;
	
	private String productName;
	
	private int quantity;
	
	
	private int price;
	
	
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getOderId() {
		return oderId;
	}


	public void setOderId(int oderId) {
		this.oderId = oderId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	
	public static ProductOderDTO transferToDTO(ProductOder productOrder) {
		ModelMapper objectMapper = new ModelMapper();
		ProductOderDTO pro = objectMapper.map(productOrder, ProductOderDTO.class);
//		pro.setOderId(productOrder.getProductOrderEmbeddable().getOderId());
//		pro.setProductId(productOrder.getProductOrderEmbeddable().getProductId());
		return pro;
	}
	
	public static ProductOderDTO transferObject(ProductOder productOrder) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(productOrder, ProductOderDTO.class);
	}
	
	public static ProductOder transferEntity(ProductOderDTO productOder) {
		ModelMapper modelmapper = new ModelMapper();
		
		ProductOder proOrder =modelmapper.map(productOder, ProductOder.class);
		return proOrder;
	}

	public ProductOderDTO() {
		
	}


	public ProductOderDTO(int productId, int oderId, String productName, int quantity, int price) {
		this.productId = productId;
		this.oderId = oderId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	

}
