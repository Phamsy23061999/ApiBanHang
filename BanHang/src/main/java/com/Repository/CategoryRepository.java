package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{


	Optional<Category> findById(int id);
	
	Category findByCategoryname(String cateName);
	
	Category findByCategorynameAndId(String cateName, Long id);
	
//	Containing
	
//	@Query(native = true, 
//	value = " SELECT * "
//		+ " FROM category c WHERE c.name LIKE %:keysearch% ")
//	Category test(@Parram("keyssearch") String keyssearch)
	
	
	
	
	
	
	
}
