package com.SWEProject.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class StoreProducts {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "STORE_PRODUCT_ID")
    private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
    @JoinColumn(name = "product_id")
	private Product product;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
    @JoinColumn(name = "store_id")
	private Store store;
	
	private Integer views;
	private Integer solds;
	private Integer available;
	private float price;
	
	public StoreProducts() {
		super();
		this.product = null;
		this.store = null;
		this.views = 0;
		this.solds = 0;
		this.available = 0;
		this.price = 0;
	}
	public StoreProducts(Product product, Store store, Integer available, float price) {
		super();
		this.product = product;
		this.store = store;
		this.views = 0;
		this.solds = 0;
		this.available = available;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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
}
