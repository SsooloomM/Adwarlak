package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private float lower;
	private float upper;
	private String category;
	private String type;   // online or offline
	private boolean onsystem;
	@ManyToOne
	private Brand brand;
	
	@OneToMany(targetEntity = StoreProducts.class, cascade = CascadeType.ALL)
	private Set<StoreProducts> stores;
	
	public Product() {
		this.name = "";
		this.lower = -1;
		this.upper = -1;
		this.category = "";
		this.type = "";   // online or offline
		this.brand = null;
		this.stores = new HashSet<StoreProducts>();
		this.onsystem = false;
	}
	
	public Product(String name, float lower, float upper, String category, String type, Brand brand,
			Set<StoreProducts> stores, boolean onsystem) {
		super();
		this.name = name;
		this.lower = lower;
		this.upper = upper;
		this.category = category;
		this.type = type;
		this.brand = brand;
		this.stores = stores;
		this.onsystem = onsystem;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Set<StoreProducts> getStores() {
		return stores;
	}

	public void setStores(Set<StoreProducts> stores) {
		this.stores = stores;
	}

	public boolean isOnsystem() {
		return onsystem;
	}

	public void setOnsystem(boolean onsystem) {
		this.onsystem = onsystem;
	}

}
