package com.DTO;

import org.modelmapper.ModelMapper;

import com.model.Category;
import com.model.CategoryProduct;

public class CategoryProductDTO {
	private long id;
	public int categoryId;
	public int productId;
	
	
	public static CategoryProductDTO transferObject(CategoryProduct categoryProductOrder) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(categoryProductOrder, CategoryProductDTO.class);
	}
	
	
	public static CategoryProduct transferEntity (CategoryProductDTO categoryProductOderDTO) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(categoryProductOderDTO, CategoryProduct.class);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
