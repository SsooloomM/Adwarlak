package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ShopOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	String userName;
	String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	@JsonBackReference
	private Set<Store> stores;
	
	public ShopOwner() {
		// TODO Auto-generated constructor stub
		this.userName = "";
		this.password = "";
		stores = new HashSet<Store>();
	}

	public ShopOwner(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		stores = new HashSet<Store>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
