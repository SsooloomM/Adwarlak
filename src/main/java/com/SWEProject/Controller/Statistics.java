package com.SWEProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Repositories.StoreProductRepository;

@Controller
public class Statistics {

	@Autowired
	private StoreProductRepository SPR;
	
	public List<StoreProducts> getMaxViewes(){
		Iterable<StoreProducts> temp = SPR.findAll();
		List<StoreProducts> storeProducts = new ArrayList<StoreProducts>();
		for(StoreProducts t : temp) {
			storeProducts.add(t);
		} 
		List<StoreProducts> result = new ArrayList<StoreProducts>();
		int Max = 1;
		for(StoreProducts sp: storeProducts) {
			if(sp.getViews() > Max) {
				result.clear();
				Max = sp.getViews();
				result.add(sp);
			}
			else if(sp.getViews() == Max) {
				result.add(sp);
			}
		}
		return result;
	}
	
	public List<StoreProducts> getMaxSold(){
		List<StoreProducts> storeProducts = (List<StoreProducts>) SPR.findAll();
		List<StoreProducts> result = new ArrayList<StoreProducts>();
		int Max = 1;
		for(StoreProducts sp: storeProducts) {
			if(sp.getSolds() > Max) {
				result.clear();
				Max = sp.getSolds();
				result.add(sp);
			}
			else if(sp.getSolds() == Max) {
				result.add(sp);
			}
		}
		return result;
	}
	
	public List<StoreProducts> getSoldout(){
		List<StoreProducts> storeProducts = (List<StoreProducts>) SPR.findAll();
		List<StoreProducts> result = new ArrayList<StoreProducts>();
		for(StoreProducts sp: storeProducts) {
			if(sp.getAvailable() == 0) {
				result.add(sp);
			}
		}
		return result;
	}
}
