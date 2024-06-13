package com.website.ThoiTrangOnline.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.TaiKhoan;
import com.website.ThoiTrangOnline.ModelDto.TaiKhoanLoginDto;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Repository.TaiKhoanRepository;

import jakarta.validation.Valid;


@Controller
public class LoginController {

	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	@Autowired 
	KhachHangRepository khachhangRepository;
	
	@GetMapping({"/login"})
	public String showLoginView(Model model) {
		TaiKhoanLoginDto taikhoanloginDto = new TaiKhoanLoginDto();
		model.addAttribute("taikhoanloginDto", taikhoanloginDto);
		return "loginview"; 
	}
	
	@PostMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("taikhoanloginDto") TaiKhoanLoginDto taikhoanloginDto, BindingResult result, Model model) {
		
		
		if(result.hasFieldErrors("tendangnhap") || result.hasFieldErrors("matkhau")) {
	        return "loginview";
	    }
		
		String tendangnhap = taikhoanloginDto.getTendangnhap();
		Optional<TaiKhoan> taikhoanfind = taikhoanRepository.findByTendangnhap(tendangnhap);
		
		if(!taikhoanfind.isEmpty() && taikhoanloginDto.getMatkhau().equals(taikhoanfind.get().getMatkhau())) {
			model.addAttribute("taikhoan", taikhoanfind.get());
			if(taikhoanfind.get().getLoai().equals("quanly")) {
				return "quanly/home";
			}
			else if(taikhoanfind.get().getLoai().equals("nhanvien")) {
				return "nhanvien/trangchunhanvien";
			}
			
			Optional<KhachHang> khachhangfind = khachhangRepository.findByTaikhoan(taikhoanfind.get());
			model.addAttribute("khachhang_id", khachhangfind.get().getId());
			return "redirect:/home?khachhang_id=" + khachhangfind.get().getId();

				
		}
		model.addAttribute("loginError", "Sai thông tin tài khoản hoặc mật khẩu");
		return "loginview";
	}
}
