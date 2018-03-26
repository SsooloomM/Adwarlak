package com.SWEProject.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Repositories.StoreProductRepository;

@Controller
public class Statistics {

	@Autowired
	StoreProductRepository SPR;
	
	public List<StoreProducts> getMaxViewes(Integer ownerId) {
		System.out.println("test");
		Iterator<StoreProducts> temp = SPR.findAll().iterator();
		List<StoreProducts> storeProducts = new ArrayList<StoreProducts>();
		StoreProducts s;
		for(Iterator<StoreProducts> t = temp; t.hasNext(); ) {
			s = t.next();
			if(s.getStore().getShopOwner().getId() == ownerId)
				storeProducts.add(s);
		} 
		List<StoreProducts> result = new ArrayList<StoreProducts>();
		int Max = 0;
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
		System.out.println("test");
		System.out.println(result.size());
		return result;
	}
	
	public List<StoreProducts> getMaxSold() {
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
	
	public List<StoreProducts> getSoldout() {
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
