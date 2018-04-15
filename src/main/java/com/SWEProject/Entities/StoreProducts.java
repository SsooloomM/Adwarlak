package com.SWEProject.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;

@Entity
public class StoreProducts {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Product product;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Store store;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer views;
	private Integer solds;
	private Integer available;
	private float price;
		
	public StoreProducts() {
		this.views = -1;
		this.solds = -1;
		this.available = -1;
		this.price = -1;
		this.store = null;
		this.product = null;
	}

	public StoreProducts(Integer views, Integer solds, Integer available, float price, Store store, Product product) {
		this.views = views;
		this.solds = solds;
		this.available = available;
		this.price = price;
		this.store = store;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getSolds() {
		return solds;
	}

	public void setSolds(Integer solds) {
		this.solds = solds;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
