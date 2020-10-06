package com.DTO;

import java.time.LocalDate;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.model.User;

public class UserDTO {
	private int id;
	
	private String username;
	
	private String adress;
	
	private String phone;
	
	private String email;
	
	private LocalDate dateCreate;
	
	

	public LocalDate getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	
	
	public static UserDTO transferObject(User users) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(users, UserDTO.class);
	}
	
	
	public static User transferEntity(UserDTO users) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(users, User.class);
	}

	

}
