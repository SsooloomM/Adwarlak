package com.SWEProject.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String type;
	private String location;
	private Boolean onSystem;
	
	@OneToMany(mappedBy = "store")
	@JsonManagedReference
	private Set<StoreProducts> storeProducts;

	public Set<StoreProducts> getStoreProducts() {
		return storeProducts;
	}

	public void setStoreProducts(Set<StoreProducts> storeProducts) {
		this.storeProducts = storeProducts;
	}

	@ManyToOne
	@JsonBackReference
	private User owner;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> collaborators;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<History> operations;
	
	public Store() {
		this.name = "";
		this.type = "";
		this.location = "";
		this.owner = null;
		this.onSystem = false;
		this.storeProducts = new HashSet<StoreProducts>();
		this.collaborators = new HashSet<User>();
		this.operations = new HashSet<History>();
	}

	public Store(String name, String type, String location, Boolean onSystem, User owner,
			Set<StoreProducts> products, Set<User> collaborators, Set<History> operations) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.onSystem = onSystem;
		this.owner = owner;
		this.storeProducts = products;
		this.collaborators = collaborators;
		this.operations = operations;
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

	public Boolean getOnSystem() {
		return onSystem;
	}

	public void setOnSystem(Boolean onSystem) {
		this.onSystem = onSystem;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<User> collaborators) {
		this.collaborators = collaborators;
	}

	public Set<History> getOperations() {
		return operations;
	}

	public void setOperations(Set<History> operations) {
		this.operations = operations;
	}

}
