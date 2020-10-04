package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


	
	 @Query(value="SELECT e.* FROM product e WHERE e.productname = :productname AND e.price = :price",nativeQuery = true)
	  List<Product> findByProductnameAndPrice(@Param("productname") String productname, @Param("price") int price);
	 
	 
	 @Query(value="SELECT e.* FROM product e WHERE e.productname = :productname limit 1",nativeQuery = true)
	  Product findByProductname(@Param("productname") String productname);
	 

}
