package com.SWEProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SWEProject.Entities.ShopOwner;
import com.SWEProject.Entities.Store;

@Controller
public class shopOwnerController {

	@RequestMapping("/ShopOwnerHome")
	public String home(Model model, @ModelAttribute ShopOwner shopOwner) {
		return "ShopOwnerHome";
	}
	
}
