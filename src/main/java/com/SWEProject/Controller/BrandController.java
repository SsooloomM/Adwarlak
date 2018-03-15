package com.SWEProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWEProject.Entities.Brand;
import com.SWEProject.Repositories.BrandRepository;

@Controller
public class BrandController {

	@Autowired
	BrandRepository BR;
	
	@GetMapping("/addBrand")
	String Invalid(Model model, @ModelAttribute Brand brand) {
		return "addBrand";
	}
	
	@PostMapping("/addBrand")
	String addBrand(Model model, @ModelAttribute Brand brand,HttpServletRequest session) {
		String type=(String)session.getSession().getAttribute("type");
		if(type!="admin")
			return "brandError";
		List<Brand> found = BR.findByName(brand.getName());
		if(!found.isEmpty())
		{
			return "brandError";
		}
		BR.save(brand);
		return "Admin Home";
	}
}
