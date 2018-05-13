package com.SWEProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Repositories.ProductRepository;
import com.SWEProject.Repositories.StoreProductRepository;
import com.SWEProject.Repositories.StoreRepository;

class toAdd{
	Store store;
	Product product;
	int avail;
	float price;
}

@RestController
public class StoreProductController {
	
	@Autowired
	private StoreProductRepository storeProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	public StoreProductController() {
		
	}
	
	@RequestMapping("/viewProduct")
	public void View(@RequestBody StoreProducts s)
	{
		StoreProducts sp = storeProductRepository.findOne(s.getId());
		System.out.println(sp.getId() + " " + sp.getViews());
		newView(sp);
		System.out.println(sp.getId() + " " + sp.getViews());
	}

	@RequestMapping("/buyProduct")
	public void buy(@RequestBody StoreProducts s)
	{
		StoreProducts sp = storeProductRepository.findOne(s.getId());
		bought(sp);
	}
	
	@RequestMapping("/getStoreProducts")
	public ArrayList<StoreProducts> getStoreProducts(@RequestBody Store s){
		List<StoreProducts> all = storeProductRepository.findAll();
		ArrayList<StoreProducts> result = new ArrayList<StoreProducts>();
		for (StoreProducts storeProducts : all) {
			if(storeProducts.getStore().getId().equals(s.getId()))
				result.add(storeProducts);
		}
		if(result.isEmpty())	return null;
		else return result;
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
		this.storeProductRepository.save(sp);
	}
	
	public ArrayList<StoreProducts> getStoreProducts(Store s, Product p){
		return storeProductRepository.findByProductAndStore(p, s);
	}
	
	@RequestMapping("/storeProducts/")
	public String showAllProducts(Model model, @RequestParam("storeID")Integer id) {
		model.addAttribute("products", storeProductRepository.findByid(id));
		return "redirect:/storeProducts";
	}
	
	@RequestMapping("/addProductToStore")
	public boolean addProductToStore(@RequestBody toAdd data, @RequestBody StoreProducts prpppoduct, @RequestBody Store sssstore) {
		Product product = (Product) data.product;
		Store store = (Store) data.store;
		product = productRepository.findOne(product.getId());
		store = storeRepository.findOne(store.getId());
		if(product == null || store == null) {
			return false;
		}
		
		if(product.isOnsystem()) {
			StoreProducts sp = new StoreProducts();
			sp.setProduct(product);
			sp.setStore(store);
			if(store.getStoreProducts().contains(sp)) {
				return false;
			}
			sp.setViews(0);
			sp.setSolds(0);
			sp.setAvailable(data.avail);
			sp.setPrice(data.price);
			
			store.getStoreProducts().add(sp);
			storeProductRepository.save(sp);
			storeRepository.save(store);
			
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
