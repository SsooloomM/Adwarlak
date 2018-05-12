package com.SWEProject.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Repositories.StoreProductRepository;

@Controller
public class Statistics {

	@Autowired
	StoreProductRepository storeProductRepository;
	
	public ArrayList<StoreProducts> getMaxViewes(Integer ownerId) {
		ArrayList<StoreProducts> storeProducts = getOwnerProducts(ownerId);
		
		ArrayList<StoreProducts> result = new ArrayList<StoreProducts>();
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
	
	public ArrayList<StoreProducts> getMaxSold(Integer ownerId) {
		ArrayList<StoreProducts> storeProducts = getOwnerProducts(ownerId);
		ArrayList<StoreProducts> result = new ArrayList<StoreProducts>();
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
	
	public ArrayList<StoreProducts> getSoldout(Integer ownerId) {
		ArrayList<StoreProducts> storeProducts = getOwnerProducts(ownerId);
		ArrayList<StoreProducts> result = new ArrayList<StoreProducts>();
		for(StoreProducts sp: storeProducts) {
			if(sp.getAvailable() == 0) {
				result.add(sp);
			}
		}
		return result;
	}
	
	private ArrayList<StoreProducts> getOwnerProducts(Integer ownerId){
		ArrayList<StoreProducts> storeProducts = storeProductRepository.findAll();
		
		for (StoreProducts storeProduct : storeProducts) {
			if(!storeProduct.getStore().getOwner().getId().equals(ownerId)) {
				storeProducts.remove(storeProduct);
			}
		}
		return storeProducts;
	}
}
