package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DTO.CategoryDTO;
import com.DTO.OderDTO;
import com.Repository.CategoryRepository;
import com.Repository.OderRepository;

import com.model.Category;
import com.model.Oder;

@Component
public class OrderDAO {
	@Autowired
	private OderRepository repository;
	
	public Oder save(int userid,int totalMoney) {
		Oder orders = new Oder();
		orders.setUserId(userid);
		orders.setTotalMoney(totalMoney);
		
		return repository.saveAndFlush(orders);
	}
	

	public Oder saveOrder(int userid) {
		Oder orders = new Oder();
		orders.setUserId(userid);
		
		
		return repository.saveAndFlush(orders);
	}
	
	public Oder findUserOrderById(int orderId){
        return repository.findById(orderId).orElse(null);
    }
	
	public OderDTO findByUserId(int userId) {
		Oder oders = repository.findByUserId(userId).get(userId);
		return OderDTO.transferObject(oders);
	}
	
	public List<OderDTO> findByUser(int userId) {
		
		List<Oder> oders = repository.findByUserId(userId);
		List<OderDTO> lists= new ArrayList<OderDTO>();
		for(Oder order: oders) {
			OderDTO orderDTO =  OderDTO.transferObject(order);
			lists.add(orderDTO);
		}
		return lists;
	}
	
	 public Oder findUserOrderById(int userId, int orderId){
	        return repository.findByIdAndUserId(orderId,userId).orElse(null);
	    }
	
	public List<OderDTO> findAll() {
		List<Oder> orders = repository.findAll();
		List<OderDTO> lists= new ArrayList<OderDTO>();
		for(Oder order: orders) {
			OderDTO orderDTO =  OderDTO.transferObject(order);
			lists.add(orderDTO);
		}
	
		return lists;
	}
	


}
