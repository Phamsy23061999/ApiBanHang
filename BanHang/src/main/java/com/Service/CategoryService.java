package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.DTO.CategoryDTO;
import com.Repository.CategoryRepository;
import com.model.Category;

import net.minidev.json.JSONObject;



@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryDao;
	
	
	
	public JSONObject getAllCategoryLike(String keysearch) {
		JSONObject js = new JSONObject();
		try {
			js.put("Category", categoryDao.getAllCategory(keysearch));
			return js ;
		} catch (Exception e) {
			js.put("Error", "Có lỗi xảy Ra");
			return null;
		}
	}
	
	public JSONObject findById(int id) {
		
		JSONObject js = new JSONObject();
		try {
			js.put("Category", categoryDao.findById(id));
			return js;
		} catch (Exception e) {
			js.put("Error", "Có lỗi xảy Ra");
			return null;
		}
		
	}
	
	
	
	public Category save(CategoryDTO cate) {
		return categoryDao.save(cate);
	}
	
	
	

}
