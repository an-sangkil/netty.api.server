package com.apiserver.core.model.dto.demo;

import org.springframework.data.annotation.Id;

public class AerospikeProduct {
	@Id
	private Integer id;
	
	private String productId;
    private String description;
    private String imageUrl;
    private double price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AerospikeProduct [id=" + id + ", productId=" + productId + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", price=" + price + "]";
	}
	
	
}
