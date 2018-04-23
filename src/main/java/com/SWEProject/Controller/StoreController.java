package com.SWEProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreOwner;
import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Entities.User;
import com.SWEProject.Repositories.ProductRepository;
import com.SWEProject.Repositories.StoreProductRepository;
import com.SWEProject.Repositories.StoreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class StoreController {

	@Autowired
	private StoreRepository SR;
	
	@GetMapping("/requestStore")
	public String requestBadMethod(Model model, @ModelAttribute Store store) {
		return "requestStore";
	}
	@PostMapping("/requestStore")
	public String requestStore(Model model, @ModelAttribute Store store,HttpServletRequest session) {
		List<Store> found = SR.findByName(store.getName());
		if(!found.isEmpty())
		{
			return "requestStoreError";
		}
		store.setOnSystem(false);
		store.setOwner((User)session.getSession().getAttribute("shopOwner"));
		SR.save(store);
		model.addAttribute("shopOwner",(StoreOwner)session.getSession().getAttribute("shopOwner"));
		return "ShopOwnerHome";
	}
	
	@RequestMapping("/showStores")
	public String Showstores(Model model, HttpServletRequest session) {
		StoreOwner shopOwner = (StoreOwner) session.getSession().getAttribute("shopOwner");
		//model.addAttribute("stores", SR.findByShopOwner(shopOwner));
		return "showStores";
	}
	
	@RequestMapping("/showAllStores")
	public String showAllStores(Model model) {
		model.addAttribute("stores", SR.findAll());
		return "showAllStores";
	}
	
	@Autowired
	private ProductRepository PR;
	
	@RequestMapping("/showProducts")
	public List<Product> showProducts() {
		List<Product> products=(List<Product>) PR.findAll();
		if(products.size()==0)
			return null;
		return products;
	}
	
	@RequestMapping("/deleteProduct")
	public void deleteProduct(@RequestBody Product product) {
		List<Product> productList=PR.findByName(product.getName());
		if(productList.isEmpty()) return;
		PR.delete(product);
	}
	
	@Autowired
	private StoreProductRepository SPR;
	
	@RequestMapping("/addProductToStore")
	private Product addProductToStore1(@RequestBody Product product) { //not sure  store wla storeproduct	
		List<StoreProducts> productlist=SPR.findByid(product.getId());
		if(!productlist.isEmpty()) return null;
		SPR.save(product);
		return product;
	}
	

	@RequestMapping("/addProductToStore")
	private Product addProductToStore(@RequestBody Product product) { //not sure  store wla storeproduct	
		List<Store> productlist=SR.findByName(product.getName());
		if(!productlist.isEmpty()) return null;
		SR.save(product);
		return product;
	}
	
	
}
