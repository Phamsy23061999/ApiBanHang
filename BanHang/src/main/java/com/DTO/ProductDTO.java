package com.DTO;

import org.modelmapper.ModelMapper;

import com.model.Category;
import com.model.Product;

public class ProductDTO {
	
	private int id;
	
	private String productName;
	
	private int price;
	
	private int quantity;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	  public static <T> T transferObject(Object model, Class<T> type){
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(model, type);
	    }

	public static Product tranferEntity(ProductDTO productDTO) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(productDTO, Product.class);
	}
	
	
}
