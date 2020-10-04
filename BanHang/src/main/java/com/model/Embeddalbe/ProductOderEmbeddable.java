package com.model.Embeddalbe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class ProductOderEmbeddable implements Serializable{
	
	
	@Column(name ="product_id" )
	private int productId;
	@Column(name = "oder_id")
	private int oderId;
	
	
	
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
	public ProductOderEmbeddable(int productId, int oderId) {
		
		this.productId = productId;
		this.oderId = oderId;
	}
	
	
	
	
	

}
