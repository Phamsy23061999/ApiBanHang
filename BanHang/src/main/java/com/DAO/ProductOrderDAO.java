package com.DAO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DTO.ProductDTO;
import com.DTO.ProductOderDTO;
import com.Repository.ProductOderRepository;
import com.Repository.ProductRepository;
import com.Respone.FindUserOrderResponse;
import com.Respone.ProductOrderRespone;
import com.model.Product;
import com.model.ProductOder;

import Request.ProductOrderRequest;
import Request.orderProductRequest;

@Component
public class ProductOrderDAO {

	@Autowired
	ProductOderRepository reposity;
	@Autowired
	ProductRepository productReposity;
	
	public List<ProductOder> findByOderId(int id) {
		
		return reposity.findByOderId(id);
	}
	public ProductOder save(int productId, int oderId, String productName, int quantity, int price) {
		ProductOder pro = new ProductOder();
		pro.setOderId(oderId);
		pro.setProductId(productId);
		pro.setProductName(productName);
		pro.setQuantity(quantity);
		pro.setPrice(price);
		return reposity.saveAndFlush(pro);
	}
	
	
	public void addNewOrderDetailDao(int orderId, List<ProductOrderRequest> orderDetail) {
		orderDetail.forEach(x ->{
			ProductOder productOrder = new ProductOder();
			productOrder.setProductId(x.getProductId());
			productOrder.setOderId(orderId);
			productOrder.setQuantity(x.getQuantity());
			reposity.saveAndFlush(productOrder);
			
		});
	} 
	
	
	public FindUserOrderResponse findByOrderDAO( int orderId) {
		List<ProductOder> productOrder = reposity.findByOderId(orderId);
		int totalPrice = productOrder.stream().mapToInt(x ->{
			Product productEntity = productReposity.findById(x.getProductId()).orElse(null);
			if(productEntity != null) {
				return productEntity.getPrice() * x.getQuantity();
			}
			return 0;
			
			}).sum();
		FindUserOrderResponse userOrderResponse = new FindUserOrderResponse();
		userOrderResponse.setTotalPrice(totalPrice);
		userOrderResponse.setListOrder(productOrder.stream().map(x ->{
			ProductOrderRespone productOrderRespone = new ProductOrderRespone();
			Product product = productReposity.findById(x.getProductId()).orElse(null);
			ProductDTO productDTO = ProductDTO.transferObject(product,ProductDTO.class);
			productOrderRespone.setProDTO(productDTO);
			productOrderRespone.setQuantity(x.getQuantity());
			
			return productOrderRespone;
			
			
		}).collect(Collectors.toList()));
		return userOrderResponse;
	}
	
	
	
	
	public ProductOder save(ProductOder pro) {
		
		return reposity.save(pro);
	}
	
	 

}
