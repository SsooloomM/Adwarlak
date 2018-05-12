package com.SWEProject.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreOwner;

public interface StoreRepository extends CrudRepository<Store, Integer> {
	ArrayList<Store> findByName(String name);
	ArrayList<Store> findByOwner(StoreOwner storeOwner);
	ArrayList<Store> findAll();

}