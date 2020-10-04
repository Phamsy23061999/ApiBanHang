package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CategoryDTO;
import com.DTO.OderDTO;
import com.Service.CategoryService;
import com.Service.OderService;

import Request.OrderRequest;
import Request.UserOrderRequest;

@RestController
@RequestMapping("/order")
public class OderController {
	@Autowired
	OderService orderService;
	
	@PostMapping("/add_order")
	public ResponseEntity<?> addOrder(@RequestBody OrderRequest orders) {
		orderService.createNewOrder(orders);
		return ResponseEntity.ok(orderService.createNewOrder(orders));
		
	}
	
	@PostMapping("/post/create_new_order")
    public ResponseEntity<?> addNewOrderController(@RequestBody UserOrderRequest request){
        return ResponseEntity.ok(orderService.addNewOrderService(request));
    }
	
	
	@GetMapping("/getall_order")
	  public List<OderDTO> getAllOrder() {
	    return  orderService.getAllODer();
	  }
	
}
