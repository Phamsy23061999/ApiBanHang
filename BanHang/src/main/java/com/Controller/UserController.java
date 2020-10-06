package com.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CategoryDTO;
import com.DTO.UserDTO;
import com.Service.UserSerVice;
import com.model.User;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserSerVice userService;
	
	
	@PostMapping("/add_user")
	public ResponseEntity<?> add(@RequestBody UserDTO userDTO) {
		
		userService.save(userDTO);
		return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping("/get/get_keysearch_username")
	public JSONObject getAllListUser(@RequestParam("keysearch") String keysearch){
		
		return  userService.getAllUsername(keysearch);
	}
	
	
	@GetMapping("/get/get_Date_Create")
	public JSONObject getAllListUserDateNew(@RequestParam("dateCreate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateCreate) {
		
		return userService.findByUserStartDateCreateBefore(dateCreate);
	}

}
