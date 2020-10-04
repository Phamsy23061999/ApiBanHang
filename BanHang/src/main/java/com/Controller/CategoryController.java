package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CategoryDTO;
import com.Service.CategoryService;
import com.model.Category;



@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
 
//
	@GetMapping("/{id}")
	public ResponseEntity<?> findByUserId(@PathVariable("id") int id) {
		CategoryDTO category = categoryservice.findById(id);
		if(category==null)
		{
			System.out.println("ID"+id+"not found");  
		}
	
	return ResponseEntity.ok(category);
	}
	
	@GetMapping("/search_categoryname")
	public ResponseEntity<?>  findByCategoryname(@RequestParam("name") String name) {
		CategoryDTO  category = categoryservice.findByCategoryname(name);
		if(category==null)
		{
			System.out.println("ID"+name+"not found");
		}
		return ResponseEntity.ok(category);
	}
	
	
	@PostMapping("/add_category")
	public ResponseEntity<?> add(@RequestBody CategoryDTO category) {
		categoryservice.save(category);
		return ResponseEntity.ok(category);
	}

}
