package com.SWEProject.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreProducts;

public interface StoreProductRepository extends CrudRepository<StoreProducts, Integer>{
	ArrayList<StoreProducts> findByProductAndStore(Product p, Store s);
	ArrayList<StoreProducts> findAll();
	ArrayList<StoreProducts> findByStore(Store store);
	StoreProducts findByid(Integer id);
}
