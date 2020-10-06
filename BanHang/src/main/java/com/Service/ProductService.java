package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.DAO.ProductDAO;
import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.model.Product;

import net.minidev.json.JSONObject;

@Service
public class ProductService {
	@Autowired
	private ProductDAO proDao;

	
	public JSONObject getProductId(int id) {
		JSONObject js = new JSONObject();
		try {
			js.put("Product", proDao.getByProductId(id));
			return js;
		}catch (Exception e) {
			js.put("Error", "Có Lỗi Xảy Ra");
			return js;
		}
		
	}
	
	public Product save(ProductDTO product) {
			return proDao.save(product);
		
	}
	
	
	public JSONObject getAllProduct(){
		JSONObject js = new JSONObject();
		try {
			js.put("Product", proDao.findAll());
			return js;
		}catch (Exception e) {
			js.put("Error", "Có Lỗi Xảy Ra");
			return js;
		}
		
	}
	public JSONObject findByProductnameAndPrice(String productName, int price){
		JSONObject js = new JSONObject();
		try {
				js.put("Product", proDao.findByProductnameAndPrice(productName, price));
				return js;
			
			} catch (Exception e) {
					js.put("Error", "Có Lỗi Xảy Ra");
					return js;
				}
		
	}
	
	public JSONObject findByProductname(String productName) {
		JSONObject js = new JSONObject();
		try {
			
			js.put("Product", proDao.finByProductname(productName));
			return js;
			
		} catch (Exception e) {
			js.put("Error", "Có Lỗi Xảy Ra");
			return js;
		}
		
	}
	
	public JSONObject updateProduct (ProductDTO pro) {
		JSONObject js = new JSONObject();
		try {
			js.put("Product", proDao.updateProuct(pro));
			return js;
		}catch (Exception e) {
			js.put("Error", "Có Lỗi Xảy Ra");
			return js;
		}
	
	}

	
	
	
	
}
