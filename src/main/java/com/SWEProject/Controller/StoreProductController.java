package com.SWEProject.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
	
	@RequestMapping(value = "/buy")
	public float buy(@RequestBody StoreProducts storeProduct, @PathParam("quantity")Integer quantity) {
		System.out.println(quantity);
		
		if(quantity>storeProduct.getAvailable())
			return (float) -1;
		storeProduct.setAvailable(storeProduct.getAvailable()-quantity);
		storeProduct.setSolds(storeProduct.getSolds()+quantity);
		SPR.save(storeProduct);
		System.out.println(quantity*storeProduct.getPrice());
		return (quantity*storeProduct.getPrice());
	}
}