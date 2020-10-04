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

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService proService;
	
	@Autowired
	private CategoryProductService categoryProductService;
	
	@GetMapping("/{id}")
	  public List<ProductDTO> getProductId(@PathVariable("id") int id) {
	    return  null;//proService.getProduct(id);
	  }
	
	@GetMapping("/getall_product")
	public List<ProductDTO>getAllProDuct(){
		return proService.getAllProduct();
	}
	//Thêm Một Sản Phẩm Theo Categori_id
	
	
	@PostMapping("/create_product")
	public ResponseEntity<?> add(@RequestBody ProductDTO pro) {
		categoryProductService.save(pro);
		return ResponseEntity.ok(pro);
	}
	//Tìm sản phẩm theo tên và giá 
	@GetMapping("/search_Productname_Price")
	 public ResponseEntity<?>searchProductName(@RequestParam("productName") String productName,@RequestParam("price") int price){
		
		 return ResponseEntity.ok( proService.findByProductnameAndPrice(productName, price));
	 }
	 //Tìm sản phẩm theo tên
	
	@GetMapping("/search_Productname")
	 public ResponseEntity<?>searchProductName(@RequestParam("productname") String productname){
		 return ResponseEntity.ok(proService.findByProductname(productname));
	 }
	
	//update sản phẩm
	@PostMapping("/update_product")
	public ResponseEntity<?> updateProduct(@RequestBody ProductDTO pro){
		return ResponseEntity.ok(proService.updateProduct(pro));
	}
	
	
	
//	
//	@PostMapping("/update/{id}")
//	public String updateProduct(@PathVariable("id") int id, @Validated Product product, BindingResult result, Model model) {
//		    if (result.hasErrors()) {
//		        product.setId(id);;
//		        return "update-product";
//		    }
//		    	proService.save(product);
//				model.addAttribute("products", proService.getAllProduct());
//				 return "redirect:/index";
//	}
		
}
