package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWEProject.Entities.Admin;
import com.SWEProject.Entities.Customer;
import com.SWEProject.Entities.ShopOwner;
import com.SWEProject.Entities.User;
import com.SWEProject.Repositories.AdminRepository;
import com.SWEProject.Repositories.CustomerRepository;
import com.SWEProject.Repositories.ShopOwnerRepository;


@Controller
public class UserController {
	
	@Autowired
	private CustomerRepository CR;
	
	@Autowired
	private ShopOwnerRepository SOR;
	
	@Autowired
	private AdminRepository AR;
	
	
	@GetMapping("/Home")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	// ============= Register =============================
	@GetMapping("/addUser")
	public String registerBadMethod(Model model, @ModelAttribute User user) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	@PostMapping("/addUser")
	public String addUser(Model model, @ModelAttribute User user) {
		if(user.getType().equals("customer")) {
			if(!addCustomer(model, user)) {
				return "error";
			}
			return "Customer Home";
		}
		else if(user.getType().equals("shopowner")) {
			if(!addShopOwner(model, user)) {
				return "error";
			}
			return "Shop Owner Home";
		}
		else {
			System.out.println("Bayz");
			return "addUser";
		}
	}
	
	public boolean addShopOwner(Model model, User user) {
		List<ShopOwner> found = SOR.findByUserName(user.getUserName());
		if(found.size() > 0) {
			return false;
		}
		ShopOwner shopOwner = new ShopOwner(user.getUserName(), user.getPassword());
		SOR.save(shopOwner);
		model.addAttribute("shopOwner", shopOwner);
		return true;
	}
	
	public boolean addCustomer(Model model, User user) {
		List<Customer> found = CR.findByUserName(user.getUserName());
		if(found.size()> 0) {
			return false;
		}
		Customer customer = new Customer(user.getUserName(), user.getPassword());
		CR.save(customer);
		model.addAttribute("customer", customer);
		return true;
	}

	//============= Login ==============================
	
	@GetMapping("/login")
	public String loginBadMethod(Model model, @ModelAttribute User user) {
		return "login";
	}
	
	@PostMapping("/login")
	public String getUser(Model model, @ModelAttribute User user) {
		if(user.getType().equals("customer")) {
			if(!getCustomer(model, user)) {
				return "error";
			}
			return "Customer Home";
		}
		else if(user.getType().equals("shopowner")) {
			if(!getShopOwner(model, user)) {
				return "error";
			}
			return "Shop Owner Home";
		}
		else if(user.getType().equals("admin")) {
			if(!getAdmin(model, user)) {
				return "error";
			}
			return "admin Home";
		}
		else {
			System.out.println("Bayz");
			return "login";
		}
	}
	
	public boolean getCustomer(Model model, User user) {
		List<Customer> found = CR.findByUserName(user.getUserName());
		if(found.isEmpty()) {
			return false;
		}
		
		if(!(found.get(0).getPassword().equals(user.getPassword()))){
			return false;
		}
		model.addAttribute("customer", found.get(0));
		return true;
	}
	
	public boolean getShopOwner(Model model, User user) {
		List<ShopOwner> found = SOR.findByUserName(user.getUserName());
		if(found.isEmpty()) {
			return false;
		}
		
		if(!(found.get(0).getPassword().equals(user.getPassword()))){
			return false;
		}
		model.addAttribute("shopOwner", found.get(0));
		return true;
	}
	public boolean getAdmin(Model model, User user) {
		List<Admin> found = AR.findByUserName(user.getUserName());
		if(found.isEmpty()) {
			return false;
		}
		
		if(!(found.get(0).getPassword().equals(user.getPassword()))){
			return false;
		}
		model.addAttribute("admin", found.get(0));
		return true;
	}

}
