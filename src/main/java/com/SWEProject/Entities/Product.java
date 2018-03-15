package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer id;
	private String name;
	private float lower;
	private float upper;
	private String category;
	private String type;   // online or offline
		
	@OneToMany(mappedBy = "product")
	private Set<Store_Products> storeProducts;
	
	
	
	public Product() {
		// TODO Auto-generated constructor stub
		this.name = "";
		this.lower = -1;
		this.upper = -1;
		this.category = "";
		this.type = "";
		this.storeProducts = new HashSet<Store_Products>();
	}


	public Product(String name, float lower, float upper, String category, Set<Store> stores, String type) {
		super();
		this.name = name;
		this.lower = lower;
		this.upper = upper;
		this.category = category;
		this.type = type;
		this.storeProducts = new HashSet<Store_Products>();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getLower() {
		return lower;
	}


	public void setLower(float lower) {
		this.lower = lower;
	}


	public float getUpper() {
		return upper;
	}


	public void setUpper(float upper) {
		this.upper = upper;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Set<Store_Products> getStoreProducts() {
		return storeProducts;
	}


	public void setStoreProducts(Set<Store_Products> storeProducts) {
		this.storeProducts = storeProducts;
	}

}
