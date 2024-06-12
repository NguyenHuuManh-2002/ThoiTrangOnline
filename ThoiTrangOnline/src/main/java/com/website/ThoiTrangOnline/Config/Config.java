package com.website.ThoiTrangOnline.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Config {
	@Bean
    @RequestMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }
}
