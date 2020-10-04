package com.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DTO.CategoryDTO;
import com.DTO.CategoryProductDTO;
import com.DTO.ProductDTO;
import com.Repository.CategoryProductReposity;
import com.Repository.CategoryRepository;

import com.model.Category;
import com.model.CategoryProduct;
import com.model.Oder;
import com.model.Product;

@Component
public class CategoryProductDAO {
	@Autowired
	CategoryProductReposity categoryProductReposity;
	
	@Autowired
	CategoryRepository categoryReposity;

	 
	
	public Product save (ProductDTO product){
		Product pro = ProductDTO.tranferEntity(product);
		return categoryProductReposity.saveAndFlush(pro);	

	}
	
	public CategoryDTO findById(int id) {
		Category cate = categoryReposity.findById(id).get();
		return CategoryDTO.transferObject(cate);
	}

	
	
	
}
