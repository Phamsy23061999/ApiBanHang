package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.DAO.ProductDAO;
import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO proDao;

	
	public List<ProductDTO> getAllProduct(){
		return  proDao.findAll();
	}
	public List<Product> findByProductnameAndPrice(String productName, int price){
		return proDao.findByProductnameAndPrice(productName, price);
	}
	public Product findByProductname(String productName) {
		return proDao.finByProductname(productName);
	}
	
	public Product updateProduct (ProductDTO pro) {
		return proDao.updateProuct(pro);
		
	}
	
}
