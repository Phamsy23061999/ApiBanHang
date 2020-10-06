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

import net.minidev.json.JSONObject;



@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
 
//
	@GetMapping("/{id}")
	public JSONObject findByUserId(@PathVariable("id") int id) {
		
		JSONObject category = categoryservice.findById(id);
		if(category==null)
		{
			System.out.println("ID"+id+"not found");  
		}
	
	return category;
	}
	
	@GetMapping("/search/search_Keysearch")
	public JSONObject getAllCategoryKeysearch(String keysearch) {
		return categoryservice.getAllCategoryLike(keysearch);
	}
	
	
	
	@PostMapping("/add_category")
	public ResponseEntity<?> add(@RequestBody CategoryDTO category) {
		JSONObject js = new JSONObject();
		js.put("Category",categoryservice.save(category) );
		return ResponseEntity.ok(js);
	}

}
