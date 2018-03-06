package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String type;
	private String location;
	private String shopOwnerName;
	private boolean onSystem;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="StoreProducts", joinColumns = @JoinColumn(name="Store_id", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name="Product_id", referencedColumnName="id"))
	private Set<Product> products;
	
	public Store() {
		// TODO Auto-generated constructor stub
		this.name = "";
		this.type = "";
		this.location = "";
		this.shopOwnerName = "";
		this.onSystem = false;
		this.products = new HashSet<Product>();  // hena fy price kman
	}
	
	public Store(String name, String type, String location, String shopOwnerName,boolean onSystem ,Set<Product> products) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.shopOwnerName = shopOwnerName;
		this.onSystem = onSystem;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getShopOwnerName() {
		return shopOwnerName;
	}

	public void setShopOwnerName(String shopOwnerName) {
		this.shopOwnerName = shopOwnerName;
	}

	public Set<Product> getProducts() {
		return products;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)        /////////    3ayzen nshof ayh da
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public boolean isOnSystem() {
		return onSystem;
	}

	public void setOnSystem(boolean onSystem) {
		this.onSystem = onSystem;
	}
	

}
