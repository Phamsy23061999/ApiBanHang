package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.OrderDAO;
import com.DTO.CategoryDTO;
import com.DTO.OderDTO;
import com.Repository.OderRepository;
import com.Respone.FindUserOrderResponse;
import com.model.Category;
import com.model.Oder;
import com.model.Product;
import com.model.ProductOder;

import Request.OrderRequest;
import Request.UserOrderRequest;
import net.minidev.json.JSONObject;

@Service
public class OderService {
	@Autowired
	private OrderDAO orders;
	
	@Autowired
	private ProductOderService proOrderService;


	public Oder createNewOrder(OrderRequest request) {
		Oder order = orders.save(request.getUserId(),request.getPrice());
		ProductOder pro = proOrderService.saveProductOrder(request.getProductId(), order.getId(), request.getProductName(), request.getQuantity(), 
				request.getPrice());

		return order;
	}
	//minidev json
	public Oder  addNewOrderService(UserOrderRequest request) {
		try {
			Oder order = orders.saveOrder(request.getUserId());
			if(order != null) {
				proOrderService.saveProductOder( request.getListOrder(),order.getId());
				return order;
			}
			return null;
			
		}catch (Exception e) {
			return null;
		}
			
		
	
	}
	
	public FindUserOrderResponse findOrderService (int userId, int orderId) {
		Oder order = orders.findUserOrderById(userId, orderId);
		if(order != null) {
			return proOrderService.findByOrderIdService(order.getId());
			
		}else {
			return null;
		}
	}
	
	public FindUserOrderResponse findOrderService(int orderId) {
		Oder order = orders.findUserOrderById(orderId);
		if(order != null) {
			return proOrderService.findByOrderIdService(order.getId());
		}else {
			return null;
		}
	}
	

	
	public List<OderDTO> finByUserId(int userId) {
		return orders.findByUser(userId);
	}
	
	public List<OderDTO> getAllODer(){
		return  orders.findAll();
	}
	
	
	
     
   
}
