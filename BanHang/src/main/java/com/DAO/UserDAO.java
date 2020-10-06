package com.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.DTO.UserDTO;
import com.Repository.UserRepository;
import com.model.Category;
import com.model.User;

@Component
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	
	public User save(UserDTO userDTO) {
		User users = UserDTO.transferEntity(userDTO);
		return userRepository.saveAndFlush(users);
	}
	
	
	public List<User> getAllUserName(String keysearch){
		
		return userRepository.findByUsernameLike(keysearch);
	}
	

}
