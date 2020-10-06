package com.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.UserDAO;
import com.DTO.CategoryDTO;
import com.DTO.UserDTO;
import com.Repository.CategoryRepository;
import com.Repository.UserRepository;

import com.model.Category;
import com.model.User;

import net.minidev.json.JSONObject;

@Service
public class UserSerVice {
	
	@Autowired
	UserDAO userDAO;

	public  User save(UserDTO userDTO) {
		return userDAO.save(userDTO);
	}
	
	public  JSONObject getAllUsername(String keysearch){
		JSONObject js = new JSONObject();
		try {
				
				js.put("User:",userDAO.getAllUserName(keysearch));
				return  js;
				
			} catch (Exception e) {
				
				js.put("Error", "Có Lỗi Xảy Ra");
				return js;
			}
		
	}
	public JSONObject findByUserStartDateCreateBefore (Date dateCreate) {
		JSONObject js = new JSONObject();
		try {
			js.put("User", userDAO.findByUserStartDateCreateBefor(dateCreate));
			return js;
		}catch (Exception e) {
			js.put("Error", "Có Lỗi Xảy Ra");
			return js;
		}
	}
	
}
