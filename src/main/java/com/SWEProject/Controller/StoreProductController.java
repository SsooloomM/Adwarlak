package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
}
