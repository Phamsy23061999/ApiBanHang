package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.DTO.CategoryDTO;
import com.Repository.CategoryRepository;
import com.model.Category;



@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryDao;
	
	public List<CategoryDTO> getAllCategory(){
		return  categoryDao.findAll();
	}
	
	
	public CategoryDTO findById(int id) {
		return categoryDao.findById(id);
	}
	
	public CategoryDTO findByCategoryname(String name) {
		return categoryDao.findByCategoryname(name);
	}
	
	public Category save(CategoryDTO cate) {
		return categoryDao.save(cate);
	}
	
	
	

}
