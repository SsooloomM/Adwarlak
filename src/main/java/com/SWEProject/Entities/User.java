package com.SWEProject.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String userName;
	private String password;
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<History> operations;

	@OneToMany(cascade= CascadeType.ALL)
	private List<Store> stores;
	
	public List<Store> getStores() {
		return stores;
	}

	public void setStores(ArrayList<Store> stores) {
		this.stores = stores;
	}

	public List<Store> getOtherStores() {
		return otherStores;
	}

	public void setOtherStores(ArrayList<Store> otherStores) {
		this.otherStores = otherStores;
	}

	@ManyToMany
	private List<Store> otherStores;
	
	public User() {
		this.userName = "";
		this.password = "";
		this.operations = new ArrayList<History>();
		this.stores = new ArrayList<Store>();
		this.otherStores = new ArrayList<Store>();
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.operations = new ArrayList<History>();
		this.stores = new ArrayList<Store>();
		this.otherStores = new ArrayList<Store>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public List<History> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<History> operations) {
		this.operations = operations;
	}

}
