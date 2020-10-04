package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CategoryDTO;
import com.DTO.ProductOderDTO;
import com.Service.ProductOderService;
import com.model.ProductOder;

@RestController
@RequestMapping("/productorder")
public class ProductOderController {
	
	@Autowired
	ProductOderService proOderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int userId) {
		List<ProductOderDTO> ProductOder =  proOderService.getProductOder(userId);
		if(ProductOder.size() == 0)
		{
			System.out.println("ID"+userId+"not found");
			return null;
		}
	
		return ResponseEntity.ok(ProductOder);
	}
	
		@PostMapping("/update_productorder")
		public ProductOder updateProductOrder(@RequestBody ProductOder pro){
			try {
				List<ProductOderDTO> pros =  proOderService.getProductOder(pro.getOderId());
		//		proOderService.save(pro);
				if(pros!=null && pros.size() != 0) {
					System.out.println("update id" + pro.getOderId());
					proOderService.save(pro);
					return pro;
				}
			//return true
			}catch (Exception e) {
				//log
			}
			System.out.println("Not exit id");
			return pro;
		
		
		}
	

}
