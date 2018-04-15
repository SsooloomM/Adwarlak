package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreOwner;

public interface StoreRepository extends CrudRepository<Store, Integer> {
	List<Store> findByName(String name);
	List<Store> findByOwner(StoreOwner storeOwner);
	List<Store> findAll();

}