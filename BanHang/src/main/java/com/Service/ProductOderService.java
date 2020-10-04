package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.DAO.ProductOrderDAO;
import com.DTO.CategoryDTO;
import com.DTO.OderDTO;
import com.DTO.ProductOderDTO;
import com.Respone.FindUserOrderResponse;
import com.model.Category;
import com.model.Oder;
import com.model.ProductOder;

import Request.ProductOrderRequest;
import Request.UserOrderRequest;
import Request.orderProductRequest;

@Service
public class ProductOderService<oderProductRequest> {
	@Autowired
	private ProductOrderDAO proOderDAO;
	@Autowired
	private OderService orderService;
	
	public List<ProductOder> getOrder(int id){
		return proOderDAO.findByOderId(id);
	}
	
	public ProductOder saveProductOrder(int productId, int orderId, String productName, int quantity, int price) {
			
		return proOderDAO.save(productId, orderId, productName, quantity, price);
	}
	
	public void saveProductOder(List<ProductOrderRequest> orderDetail, int orderId) {
		 proOderDAO.addNewOrderDetailDao(orderId,orderDetail);
		
	}
	
	public FindUserOrderResponse  findByOrderIdService (int orderId ) {
		return proOderDAO.findByOrderDAO(orderId);
	}
	
	public List<ProductOder> getProductOder(int userId){
		List<OderDTO> oder= orderService.finByUserId(userId);
		List<ProductOder> ProductOder = proOderDAO.findByOderId(oder.get(oder.size()).getId());
		return ProductOder;
		
	}
	

	public ProductOder save(ProductOder pro) {
		return proOderDAO.save(pro);
	}
	

	
}
