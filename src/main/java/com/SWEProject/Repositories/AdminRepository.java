package com.SWEProject.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEProject.Entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	List<Admin> findByUserName(String userName);
}
