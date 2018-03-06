package com.SWEProject.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SWEProject.Entities.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {
	List<Store> findByName(String name);
}