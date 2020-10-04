package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.model.Category;
import com.model.Oder;
import com.model.ProductOder;

@Repository
public interface OderRepository extends JpaRepository<Oder, Integer> {

//	Optional<Oder> findByUserId(int userId);
	
	List<Oder> findByUserId(int userId);

	Optional<Oder> findByIdAndUserId(int orderId, int userId);
	
	
	
    
	
}
