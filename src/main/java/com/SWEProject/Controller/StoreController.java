package com.SWEProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SWEProject.Entities.User;
import com.SWEProject.Entities.StoreOwner;
import com.SWEProject.Entities.Store;
import com.SWEProject.Repositories.StoreRepository;

@Controller
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
	
}
