package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DTO.ProductOderDTO;
import com.model.Oder;
import com.model.ProductOder;
import com.model.Embeddalbe.ProductOderEmbeddable;

@Repository
public interface ProductOderRepository extends JpaRepository<ProductOder, Integer> {
	 
	
	List<ProductOder> findByOderId(int oderId);

	
	
	
	
}
