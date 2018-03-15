package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreProducts;

public interface StoreProductRepository extends CrudRepository<StoreProducts, Integer>{
	List<StoreProducts> findByProductAndStore(Product p, Store s);
}
