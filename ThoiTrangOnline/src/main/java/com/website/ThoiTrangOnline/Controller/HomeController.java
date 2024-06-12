package com.website.ThoiTrangOnline.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public String showHomeview(@RequestParam String khachhang_id, Model model) {
		
		model.addAttribute("khachhang_id", khachhang_id);
		return "khachhang/trangchukhachhang";
	}
}
