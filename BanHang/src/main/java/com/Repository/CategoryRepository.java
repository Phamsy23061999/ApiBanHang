package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Category;
import com.model.User;


public interface CategoryRepository extends JpaRepository<Category, Integer>{


	Optional<Category> findById(int id);
	
	Category findByCategoryname(String cateName);
	
	Category findByCategorynameAndId(String cateName, Long id);
	
	@Query(value="SELECT u.* FROM category u WHERE u.category_name like %:keysearch%",nativeQuery = true)
	List<Category> findByCategoryLike(@Param("keysearch") String keysearch);
	
	
	
//	Containing
	
//	@Query(native = true, 
//	value = " SELECT * "
//		+ " FROM category c WHERE c.name LIKE %:keysearch% ")
//	Category test(@Parram("keyssearch") String keyssearch)
	
	
	
	
	
	
	
}
