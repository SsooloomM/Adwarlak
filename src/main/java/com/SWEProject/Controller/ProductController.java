package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Product;
import com.SWEProject.Repositories.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
//	@GetMapping("/addProduct")
//	String showForm(Model model, @ModelAttribute Product product) {
//		return "addProduct";
//	}
//	
//	@PostMapping("/addProduct")
//	String addProduct(Model model, @ModelAttribute Product product,HttpServletRequest session) {
//		String type=(String)session.getSession().getAttribute("type");
//		if(type!="admin")
//			if(type=="shopOwner")
//				return "ShopOwnerHome";
//			else
//				return "Customer Home";
//		List<Product> found = PR.findByName(product.getName());
//		if(!found.isEmpty())
//			return "productError";
//		
//		System.out.println(product.getId());
//		System.out.println(product.getName());
//		System.out.println(product.getCategory());
//		System.out.println(product.getUpper());
//		System.out.println(product.getType());
//		PR.save(product);
//		model.addAttribute("admin",(Admin)session.getSession().getAttribute("admin"));
//		return "Admin Home";
//	}
	
<<<<<<< HEAD
<<<<<<< HEAD
//	@GetMapping("/addProduct")
//	String showForm(Model model, @ModelAttribute Product product) {
//		return "addProduct";
//	}
	
//	@PostMapping("/addProduct")
//	String addProduct(Model model, @ModelAttribute Product product,HttpServletRequest session) {
//		String type=(String)session.getSession().getAttribute("type");
//		if(type!="admin")
//			if(type=="shopOwner")
//				return "ShopOwnerHome";
//			else
//				return "Customer Home";
//		List<Product> found = PR.findByName(product.getName());
//		if(!found.isEmpty())
//			return "productError";
//		
//		System.out.println(product.getId());
//		System.out.println(product.getName());
//		System.out.println(product.getCategory());
//		System.out.println(product.getUpper());
//		System.out.println(product.getType());
//		PR.save(product);
//		model.addAttribute("admin",(Admin)session.getSession().getAttribute("admin"));
//		return "Admin Home";
//	}
=======
=======
>>>>>>> c3c6760ba5d1f23e7032899b73033ac639728c12
	@RequestMapping("/addProductToSystem")
	public boolean addProductToSystem(@RequestBody Product product) {
		
		List<Product> products = productRepository.findByName(product.getName());
		if(products.isEmpty()) {
			
			product.setOnsystem(true);
			productRepository.save(product);
			return true;
		}
		return false;
	}
	
	@RequestMapping("/requestProduct")
	public boolean requestProduct(@RequestBody Product product) {
		
		List<Product> found = productRepository.findByName(product.getName());
		if(found.isEmpty()) {
			
			product.setOnsystem(false);
			productRepository.save(product);
			return true;
		}
		return false;
	}
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> c3c6760ba5d1f23e7032899b73033ac639728c12
}
