package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByName(String name);
}
