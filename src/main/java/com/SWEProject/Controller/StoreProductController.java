package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Repositories.StoreProductRepository;

@Controller
public class StoreProductController {
	
	@Autowired
	private StoreProductRepository SPR;
	
	public StoreProductController() {
		
	}
	
	@RequestMapping("/addProductToTheStore/")
	public String addProduct(@RequestParam (value = "storeId") Integer id) {
		
		return "addProductToTheStore"; 
	}
	
	public void newView(StoreProducts sp) {
		sp.setViews(sp.getViews() + 1);
		save(sp);
	}
	
	public void bought(StoreProducts sp) {
		sp.setAvailable(sp.getAvailable() - 1);
		sp.setSolds(sp.getSolds() + 1);
		save(sp);
	}
	
	public void save(StoreProducts sp) {
		this.SPR.save(sp);
	}
	
	public List<StoreProducts> getStoreProducts(Store s, Product p){
		return SPR.findByProductAndStore(p, s);
	}
	
	@RequestMapping("/storeProducts/")
	public String showAllProducts(Model model, @RequestParam("storeID")Integer id) {
		model.addAttribute("products", SPR.findByid(id));
		return "redirect:/storeProducts";
	}
	
	@RequestMapping("/addProductToStore")
	public boolean addProductToStore(@RequestBody Product product, @RequestBody Store store) {
		if(product.isOnsystem()) {
			StoreProducts sp = new StoreProducts();
			sp.setProduct(product);
			sp.setStore(store);
			if(store.getStoreProducts().contains(sp)) {
				return false;
			}
			store.getStoreProducts().add(sp);
			return true;
		}
		else
			return false;
	}
	@RequestMapping("/deleteStoreProduct")
	public boolean deleteStoreProduct(@RequestBody StoreProducts product, @RequestBody Store store) {
		
		if(store.getStoreProducts().contains(product)) {
			store.getStoreProducts().remove(product);
			return true;
		}
		return false;
	}
}
