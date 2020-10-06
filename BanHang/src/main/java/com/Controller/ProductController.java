package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.Service.CategoryProductService;
import com.Service.CategoryService;
import com.Service.ProductService;
import com.model.Product;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService proService;
	
	@Autowired
	private CategoryProductService categoryProductService;
	
	@GetMapping("/{id}")
	  public JSONObject getProductId(@PathVariable("id") int id) {
		
	    return  proService.getProductId(id);
	  }
	
	@GetMapping("/getall_product")
	public JSONObject getAllProDuct(){
		return proService.getAllProduct();
	}
	
	
	
	@PostMapping("/create_product")
	public ResponseEntity<?> add(@RequestBody ProductDTO product) {
		JSONObject js = new JSONObject();
		js.put("Product", proService.save(product));
		return ResponseEntity.ok(js);
		
	}
		
	
	
	//Tìm sản phẩm theo tên và giá 
	@GetMapping("/search_Productname_Price")
	 public JSONObject searchProductName(@RequestParam("productName") String productName,@RequestParam("price") int price){
		
		 return  proService.findByProductnameAndPrice(productName, price);
	 }
	
	
	 //Tìm sản phẩm theo tên
	
	@GetMapping("/search_Productname")
	 public JSONObject searchProductName(@RequestParam("productname") String productname){
		 return proService.findByProductname(productname);
	 }
	
	//update sản phẩm(cần chỉnh sửa)
	@PostMapping("/update_product")
	public JSONObject updateProduct(@RequestBody ProductDTO pro){
		return proService.updateProduct(pro);
	}
	
	
		
}
