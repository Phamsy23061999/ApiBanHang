package com.Service;

import java.util.ArrayList;
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
		try {
				JSONObject js = new JSONObject();
				js.put("User:",userDAO.getAllUserName(keysearch));
				return  js;
//				if(keysearch == null) {
//					JSONObject js = new JSONObject();
//					js.put("Error", "Lỗi");
//					return js;
//				}else {
//					
//				}
				
			} catch (Exception e) {
				JSONObject js = new JSONObject();
				js.put("Error", "Có Lỗi Xảy Ra");
				return js;
			}
			
		
	}
	
}
