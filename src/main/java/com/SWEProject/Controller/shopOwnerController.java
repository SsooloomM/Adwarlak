package com.SWEProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SWEProject.Entities.ShopOwner;

@Controller
public class shopOwnerController {

	private Statistics s = new Statistics();
	
	@RequestMapping("/ShopOwnerHome")
	public String home(Model model, @ModelAttribute ShopOwner shopOwner) {
		return "ShopOwnerHome";
	}
	
	@RequestMapping("/getMaxView")
	public String getMaxView(Model model) {
		model.addAttribute("products", s.getMaxViewes());
		return "statistics"; 
	}
	@RequestMapping("/getSoldOut")
	public String getSoldOut(Model model) {
		model.addAttribute("products", s.getSoldout());
		return "statistics"; 
	}
	@RequestMapping("/getMaxSold")
	public String getMaxSold(Model model) {
		model.addAttribute("products", s.getMaxSold());
		return "statistics"; 
	}
}
