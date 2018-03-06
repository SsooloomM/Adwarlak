package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByUserName(String userName);
}
