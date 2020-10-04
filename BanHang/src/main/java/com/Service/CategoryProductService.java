package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.DAO.CategoryProductDAO;
import com.DTO.CategoryDTO;
import com.DTO.CategoryProductDTO;
import com.DTO.OderDTO;
import com.DTO.ProductDTO;
import com.DTO.ProductOderDTO;
import com.model.Category;
import com.model.CategoryProduct;
import com.model.Oder;
import com.model.Product;
import com.model.ProductOder;

import Request.OrderRequest;


@Service
public class CategoryProductService {
	@Autowired
	private CategoryProductDAO categoryProductDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	public Product save(ProductDTO product) {
		return categoryProductDAO.save(product);
	}
		
	public CategoryDTO findById(int id) {
		return categoryDAO.findById(id);
	}
	
	
	
	
	
	
	
	
	
	
}
