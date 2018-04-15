package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String userName;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<History> operations;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Store> stores;
	
	@ManyToMany(mappedBy = "collaborators")
	private Set<Store> otherStores;
	
	public User() {
		this.userName = "";
		this.password = "";
		this.operations = new HashSet<History>();
		this.stores = new HashSet<Store>();
		this.otherStores = new HashSet<Store>();
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.operations = new HashSet<History>();
		this.stores = new HashSet<Store>();
		this.otherStores = new HashSet<Store>();
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

	public Set<History> getOperations() {
		return operations;
	}

	public void setOperations(Set<History> operations) {
		this.operations = operations;
	}

}
