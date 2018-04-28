package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
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
	
//	@GetMapping("/requestStore")
//	public String requestBadMethod(Model model, @ModelAttribute Store store) {
//		return "requestStore";
//	}
//	@PostMapping("/requestStore")
//	public String requestStore(Model model, @ModelAttribute Store store,HttpServletRequest session) {
//		List<Store> found = SR.findByName(store.getName());
//		if(!found.isEmpty())
//		{
//			return "requestStoreError";
//		}
//		store.setOnSystem(false);
//		store.setOwner((User)session.getSession().getAttribute("shopOwner"));
//		SR.save(store);
//		model.addAttribute("shopOwner",(StoreOwner)session.getSession().getAttribute("shopOwner"));
//		return "ShopOwnerHome";
//	}
//	
	@RequestMapping("/showAllStores")
	public List<Store> showAllStores() {
		List<Store> stores = SR.findAll();
		if(stores.size() == 0)
			return null;
		
		return stores;
	}
	@RequestMapping("/addOwner")
	public void addOwner(@RequestBody User owner,@RequestBody Store store ) {
		store.getCollaborators().add(owner);
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
	public boolean deleteProduct(@RequestBody Product product) {
		List<Product> productList=PR.findByName(product.getName());
		if(productList.isEmpty()) return false;
		PR.delete(product);
		return true;
	}


	
}
