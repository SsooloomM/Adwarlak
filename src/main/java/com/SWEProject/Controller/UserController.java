package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWEProject.Entities.User;
import com.SWEProject.Repositories.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
	@Autowired
	private UserRepository UR;
	
	//@Autowired
	//private CustomerRepository CR;
	
//	@Autowired
//	private ShopOwnerRepository SOR;
//	
//	@Autowired
//	private AdminRepository AR;
//	
	
//	@GetMapping("/Home")
//	public String Home() {
//		return "Home";
//	}
	
//	@GetMapping("/error")
//	public String error() {
//		return "error";
//	}
	
	private User getUser(String name) {
		List<User> users  = UR.findByUserName(name);
		if(users.isEmpty()) return null;
		return users.get(0);
	}
	
	// ============= Register =============================
	
	@RequestMapping("/addUser")
	public User Register(@RequestBody User input) {
		User user = getUser(input.getUserName());
		if(user == null) {
			user = new User(input.getUserName(), input.getPassword());
			UR.save(user);
			return user;
		}
		return null;
	}
	
	@RequestMapping("/login")
	public User login(@RequestBody User u) {
		User user = getUser(u.getUserName());
		if(user == null || !user.getPassword().equals(u.getPassword())) {
			return null;
		}
		
		return user;
	}
	
	
	
//	public Customer addCustomer2(String name, String password) {
//		List<Customer> found = CR.findByUserName(name);
//		if(found.size()> 0) {
//			return null;
//		}
//		Customer customer = new Customer(name, password);
//		CR.save(customer);
//		model.addAttribute("customer", customer);
//		return customer;
//	}
	
//	@GetMapping("/addUser")
//	public String registerBadMethod(Model model, @ModelAttribute User user) {
//		model.addAttribute("user", new User());
//		return "addUser";
//	}
//	@PostMapping("/addUser")
//	public String addUser(Model model, @ModelAttribute User user) {
//		if(user.getType().equals("customer")) {
//			if(!addCustomer(model, user)) {
//				return "error";
//			}
//			return "Customer Home";
//		}
//		else if(user.getType().equals("shopowner")) {
//			if(!addShopOwner(model, user)) {
//				return "error";
//			}
//			return "ShopOwnerHome";
//		}
//		else {
//			System.out.println("Bayz");
//			return "addUser";
//		}
//	}
	
//	public boolean addShopOwner(Model model, User user) {
//		List<StoreOwner> found = SOR.findByUserName(user.getUserName());
//		if(found.size() > 0) {
//			return false;
//		}
//		StoreOwner shopOwner = new StoreOwner(user.getUserName(), user.getPassword());
//		SOR.save(shopOwner);
//		model.addAttribute("shopOwner", shopOwner);
//		return true;
//	}
	
//	public boolean addCustomer(Model model, User user) {
//		List<Customer> found = CR.findByUserName(user.getUserName());
//		if(found.size()> 0) {
//			return false;
//		}
//		Customer customer = new Customer(user.getUserName(), user.getPassword());
//		CR.save(customer);
//		model.addAttribute("customer", customer);
//		return true;
//	}

	//============= Login ==============================
	
//	@RequestMapping("/login/customer")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Customer customerLogin(@PathParam("name") String name, @PathParam("password") String password) {
//		Customer customer = getCustomer2(name);
//		if(customer == null || !customer.getPassword().equals(password)) {
//			return null;
//		}
//		
//		return customer;
//	}
//	
//	public Customer getCustomer2(String name) {
//		List<Customer> found = CR.findByUserName(name);
//		if(found.isEmpty()) {
//			return null;
//		}
//		return found.get(0);
//	}

	
//	@GetMapping("/login")
//	public String loginBadMethod(Model model, @ModelAttribute User user) {
//		return "login";
//	}
	
//	@PostMapping("/login")
//	public String getUser(Model model, @ModelAttribute User user, HttpServletRequest session) {
//		if(user.getType().equals("customer")) {
//			if(!getCustomer(model, user, session)) {
//				return "error";
//			}
//			return "Customer Home";
//		}
//		else if(user.getType().equals("shopowner")) {
//			if(!getShopOwner(model, user, session)) {
//				return "error";
//			}
//			return "ShopOwnerHome";
//		}
//		else if(user.getType().equals("admin")) {
//			if(!getAdmin(model, user, session)) {
//				return "error";
//			}
//			return "Admin Home";
//		}
//		else {
//			System.out.println("Bayz");
//			return "login";
//		}
//	}
	
//	public boolean getCustomer(Model model, User user, HttpServletRequest session) {
//		List<Customer> found = CR.findByUserName(user.getUserName());
//		if(found.isEmpty()) {
//			return false;
//		}
//		
//		if(!(found.get(0).getPassword().equals(user.getPassword()))){
//			return false;
//		}
//		model.addAttribute("customer", found.get(0));
//		return true;
//	}
//	
//	public boolean getShopOwner(Model model, User user, HttpServletRequest session) {
//		List<StoreOwner> found = SOR.findByUserName(user.getUserName());
//		if(found.isEmpty()) {
//			return false;
//		}
//		
//		if(!(found.get(0).getPassword().equals(user.getPassword()))){
//			return false;
//		}
//		model.addAttribute("shopOwner", found.get(0));
//		session.getSession().setAttribute("shopOwner",found.get(0));
//		return true;
//	}
//	public boolean getAdmin(Model model, User user, HttpServletRequest session) {
//		List<Admin> found = AR.findByUserName(user.getUserName());
//		if(found.isEmpty()) {
//			return false;
//		}
//		
//		if(!(found.get(0).getPassword().equals(user.getPassword()))){
//			return false;
//		}
//		model.addAttribute("admin", found.get(0));
//		session.getSession().setAttribute("admin",found.get(0));
//		session.getSession().setAttribute("type","admin");
//		return true;
//	}

}
