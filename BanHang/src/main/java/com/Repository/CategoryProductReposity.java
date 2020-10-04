package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DTO.CategoryProductDTO;
import com.model.CategoryProduct;
import com.model.Product;
import com.model.ProductOder;

public interface CategoryProductReposity extends JpaRepository<CategoryProduct, Integer> {

	List<CategoryProductDTO> findByCategoryId(int id);

	Product saveAndFlush(Product pro);
	
	
	
	
}
