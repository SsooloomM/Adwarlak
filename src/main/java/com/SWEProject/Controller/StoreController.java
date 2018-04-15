package com.SWEProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.User;
import com.SWEProject.Entities.StoreOwner;
import com.SWEProject.Entities.Store;
import com.SWEProject.Repositories.StoreRepository;

@RestController
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
	public List<Store> showAllStores() {
		List<Store> stores = SR.findAll();
		if(stores.size() == 0)
			return null;
		
		return stores;
	}
	
}
