package com.SWEProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/addProduct")
	String showForm(Model model, @ModelAttribute Product product) {
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	String addProduct(Model model, @ModelAttribute Product product,HttpServletRequest session) {
		String type=(String)session.getSession().getAttribute("type");
		if(type!="admin")
			if(type=="shopOwner")
				return "ShopOwnerHome";
			else
				return "Customer Home";
		List<Product> found = PR.findByName(product.getName());
		if(!found.isEmpty())
			return "productError";
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getCategory());
		System.out.println(product.getUpper());
		System.out.println(product.getType());
		PR.save(product);
		model.addAttribute("admin",(Admin)session.getSession().getAttribute("admin"));
		return "Admin Home";
	}
}
