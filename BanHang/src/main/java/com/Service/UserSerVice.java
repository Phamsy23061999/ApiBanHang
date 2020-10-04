package com.Service;

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

@Service
public class UserSerVice {
	
	@Autowired
	UserDAO userDAO;

	public User save(UserDTO userDTO) {
		return userDAO.save(userDTO);
	}
	
	
	
}
