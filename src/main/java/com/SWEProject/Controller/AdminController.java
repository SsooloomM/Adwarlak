package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Repositories.AdminRepository;
import com.SWEProject.Repositories.ProductRepository;
import com.SWEProject.Repositories.StoreRepository;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
	@Autowired
	private AdminRepository AR;
	
	@Autowired
	private ProductRepository PR;
	
	@RequestMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {	
		List<Product> productList=PR.findByName(product.getName());
		if(!productList.isEmpty()) return null;
		PR.save(product);
		return product;
	}
	
	@RequestMapping("/approveProduct")
	public Product approveProduct(@RequestParam("id") int productId) {
		Product product=PR.findOne(productId);
		product.setOnsystem(true);
		PR.save(product);
		return product;
	}
	
	
	@Autowired
	private StoreRepository SR;
	
	@RequestMapping("/approveStore")
	public Store approveStore(@RequestParam("id") int storeId) {
		Store store=SR.findOne(storeId);
		store.setOnSystem(true);
		SR.save(store);
		return store;
	}
	
	
	
	
	
}
