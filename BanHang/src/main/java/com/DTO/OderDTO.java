package com.DTO;

import java.util.Date;
import java.util.Set;

import javax.persistence.ManyToMany;

import org.modelmapper.ModelMapper;

import com.model.Category;
import com.model.Oder;

public class OderDTO {
	
	private int id;
	
	private int userId;
	private int totalMoney;
	
	
	
	public int getId() {
		return id;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static OderDTO transferObject(Oder oders) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(oders, OderDTO.class);
	}
	
	public static OderDTO transferEntity(Oder oders) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(oders, OderDTO.class);
	}
	
	
	

}
