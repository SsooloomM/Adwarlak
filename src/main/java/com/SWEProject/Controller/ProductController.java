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
	@RequestMapping("/approveProduct")
	public boolean approveProduct(@RequestBody Product product) {
		product = productRepository.findOne(product.getId());
		if(product == null) {
			return false;
		}
		product.setOnsystem(true);
		productRepository.save(product);
		return true;
	}
	
	@RequestMapping("/showProducts")
	public List<Product> showProducts() {
		List<Product> products=(List<Product>) productRepository.findAll();
		if(products.size()==0)
			return null;
		return products;
	}
	
	@RequestMapping("/deleteProduct")
	public boolean deleteProduct(@RequestBody Product product) {
		List<Product> productList=productRepository.findByName(product.getName());
		if(productList.isEmpty()) return false;
		productRepository.delete(product);
		return true;
	}
}
