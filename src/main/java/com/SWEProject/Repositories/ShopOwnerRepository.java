package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.ShopOwner;

public interface ShopOwnerRepository extends CrudRepository<ShopOwner, Integer>{
	List<ShopOwner> findByUserName(String userName);
}
