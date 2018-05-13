package com.SWEProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SWEProject.Entities.Brand;
import com.SWEProject.Repositories.BrandRepository;

@Controller
public class BrandController {

	@Autowired
	BrandRepository brandRepository;
	
//	@GetMapping("/addBrand")
//	String Invalid(Model model, @ModelAttribute Brand brand) {
//		return "addBrand";
//	}
//	
//	@PostMapping("/addBrand")
//	String addBrand(Model model, @ModelAttribute Brand brand,HttpServletRequest session) {
//		String type=(String)session.getSession().getAttribute("type");
//		if(type!="admin")
//			return "brandError";
//		List<Brand> found = BR.findByName(brand.getName());
//		if(!found.isEmpty())
//		{
//			return "brandError";
//		}
//		BR.save(brand);
//		return "Admin Home";
//	}
	
	@RequestMapping("/addBrandToSystem")
	public boolean addBrandToSystem(@RequestBody Brand brand) {
		
		List<Brand> brands = brandRepository.findByName(brand.getName());
		if(brands.isEmpty()) {
			brandRepository.save(brand);
			return true;
		}
		return false;
	}
}
