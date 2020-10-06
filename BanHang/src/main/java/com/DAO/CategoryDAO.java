package com.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DTO.CategoryDTO;
import com.DTO.UserDTO;
import com.Repository.CategoryRepository;
import com.model.Category;
import com.model.User;

@Component
public class CategoryDAO {
	
	@Autowired
	private CategoryRepository repository;

	
	public CategoryDTO findByCategoryname(String cateName) {
		
		Category cate = repository.findByCategoryname(cateName);
		return CategoryDTO.transferObject(cate);
	}
	
	public List<CategoryDTO> findAll() {
		List<Category> cates = repository.findAll();
		List<CategoryDTO> lists= new ArrayList<CategoryDTO>();
		for(Category cate: cates) {
			CategoryDTO cateDTO =  CategoryDTO.transferObject(cate);
			lists.add(cateDTO);
		}
		return lists;
	}
	
	
	
	public List<Category> getAllCategory(String keysearch){
		
		return repository.findByCategoryLike(keysearch);
	}
	
	
	public CategoryDTO findById(int id) {
		Category cate = repository.findById(id).get();
		return CategoryDTO.transferObject(cate);
	}
	 
	
	
	public Category save(CategoryDTO category) {
		Category cate = CategoryDTO.transferEntity(category);
		return repository.saveAndFlush(cate);
	}

	
}
