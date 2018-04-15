package com.SWEProject.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SWEProject.Entities.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByUserName(String userName);
}
