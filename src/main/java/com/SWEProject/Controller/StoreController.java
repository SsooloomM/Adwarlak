package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.StoreProducts;
import com.SWEProject.Entities.User;
import com.SWEProject.Repositories.StoreRepository;

class toAddStore{
	public User user;
	public Store store;
}

@RestController
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepository;
	
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
		List<Store> stores = storeRepository.findAll();
		if(stores.size() == 0)
			return null;
		return stores;
	}
//	@RequestMapping("/addOwner")
//	public void addOwner(@RequestBody User owner,@RequestBody Store store ) {
//		store.getCollaborators().add(owner);
//	}
	
//	@RequestMapping("/getStoreProducts")
//	public List<StoreProducts> getStoreProducts(@RequestBody Store s){
//		
//		return null;
//	}
	
	@RequestMapping("/approveStore")
	public boolean approveStore(@RequestBody Store s) {
		s = storeRepository.findOne(s.getId());
		if(s == null) {
			return false;
		}
		s.setOnSystem(true);
		storeRepository.save(s);
		return true;
	}
	
	@RequestMapping("/requestStore")
	public boolean requestStore(@RequestBody toAddStore ob) {
		User user = (User) ob.user;
		Store store = (Store)ob.store;
	
		List<Store> found = storeRepository.findByName(store.getName());
		if(!found.isEmpty()) {
			return false;
		}
		
		store.setOnSystem(false);
		store.setOwner(user);
		storeRepository.save(store);
		return true;
	}
	
}
