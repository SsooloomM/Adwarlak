package com.SWEProject.Entities;

import javax.persistence.*;

import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;

@Entity
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Store store;
	
	private String operation;
	
	@ManyToOne
	private StoreProducts before;
	@ManyToOne
	private StoreProducts after;
	
	public History() {
		this.user = null;
		this.store = null;
		this.operation = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
