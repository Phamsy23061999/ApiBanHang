package com.DTO;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Category;

public class CategoryDTO {
	
	private int id;
	
	private String categoryname;
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	public static CategoryDTO transferObject(Category category) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(category, CategoryDTO.class);
	}
	
	public static Category transferEntity(CategoryDTO category) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(category, Category.class);
	}

}
