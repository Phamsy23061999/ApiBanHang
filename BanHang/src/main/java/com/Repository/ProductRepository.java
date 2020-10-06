package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Product;
import com.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


		Optional<Product> findById(int id);
	
	 @Query(value="SELECT e.* FROM product e WHERE e.productname = :productname AND e.price = :price",nativeQuery = true)
	  List<Product> findByProductnameAndPrice(@Param("productname") String productname, @Param("price") int price);
	 
	 
	 @Query(value="SELECT e.* FROM product e WHERE e.productname = :productname limit 1",nativeQuery = true)
	  Product findByProductname(@Param("productname") String productname);
	 
	 @Query(value="SELECT u.* FROM product u WHERE u.productname like %:keysearch%",nativeQuery = true)
		List<Product> findByProductnameLike(@Param("keysearch") String keysearch);
	 
	 
}
