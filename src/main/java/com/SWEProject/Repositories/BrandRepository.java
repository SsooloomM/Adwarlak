package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Brand;

public interface BrandRepository extends CrudRepository<Brand,Integer>{
	List<Brand> findByName(String name);
}
