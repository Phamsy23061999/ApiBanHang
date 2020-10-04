package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.Repository.ProductRepository;
import com.model.Category;
import com.model.Product;

@Component
public class ProductDAO {
	
	@Autowired
	private ProductRepository repository;

	public List<ProductDTO> findAll() {
		List<Product> product = repository.findAll();
		List<ProductDTO> lists= new ArrayList<ProductDTO>();
		for(Product pro: product) {
			ProductDTO proDTO =  ProductDTO.transferObject(pro, ProductDTO.class);
			lists.add(proDTO);
		}
		
		return lists;
	}
	
	
	
	public Product updateProuct (ProductDTO productDTO) {
		Product pro = repository.findById(productDTO.getId()).orElse(null);
		if(pro != null) {
			Product pros = repository.saveAndFlush(pro);
			return pros;
		}
		return null;
	}
	
	
	public List<Product> findByProductnameAndPrice(String productname, int price){
		return repository.findByProductnameAndPrice(productname, price);
		
	}
	
	public Product finByProductname(String productName) {
		return repository.findByProductname(productName);
	}
	
} 
