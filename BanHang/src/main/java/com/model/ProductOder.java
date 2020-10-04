package com.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.model.Embeddalbe.ProductOderEmbeddable;
import com.sun.istack.Nullable;

@Entity
@Table(name ="product_oder")
public class ProductOder {
	

	@Id
	@Column(name ="product_id" )
	private int productId;
	
	@Column(name = "oder_id")
	private int oderId;
	
	
	
	@Nullable
	@Column(name = "productname")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
	
	
	
	



	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public int getOderId() {
		return oderId;
	}




	public void setOderId(int oderId) {
		this.oderId = oderId;
	}


	
	
	

}
