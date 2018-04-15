//package com.SWEProject.Controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.SWEProject.Entities.StoreOwner;
//
//@Controller
//public class shopOwnerController {
//
////	private Statistics s = new Statistics();
//	
//	@RequestMapping("/ShopOwnerHome")
//	public String home(Model model, @ModelAttribute StoreOwner shopOwner) {
//		return "ShopOwnerHome";
//	}
//	
////	@RequestMapping("/getMaxView")
////	public String getMaxView(Model model, HttpServletRequest session) {
////		Statistics s = new Statistics();
////		model.addAttribute("products", s.getMaxViewes(((StoreOwner)session.getSession().getAttribute("shopOwner")).getId()));
////		return "statistics"; 
////	}
////	@RequestMapping("/getSoldOut")
////	public String getSoldOut(Model model) {
////		Statistics s = new Statistics();
////		model.addAttribute("products", s.getSoldout());
////		return "statistics"; 
////	}
//	@RequestMapping("/getMaxSold")
//	public String getMaxSold(Model model) {
//		Statistics s = new Statistics();
//		model.addAttribute("products", s.getMaxSold());
//		return "statistics"; 
//	}
//}
