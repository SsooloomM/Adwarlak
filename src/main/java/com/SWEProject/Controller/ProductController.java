package com.SWEProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWEProject.Entities.Admin;
import com.SWEProject.Entities.Product;
import com.SWEProject.Repositories.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository PR;
	
	@GetMapping("/add product to system")
	String showForm(Model model, @ModelAttribute Product product) {
		return "add product to system";
	}
	
	@PostMapping("/add product to system")
	String addProduct(Model model, @ModelAttribute Product product) {
		PR.save(product);
		return "Admin Home";
	}

}
