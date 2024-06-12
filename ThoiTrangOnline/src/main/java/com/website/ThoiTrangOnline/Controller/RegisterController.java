package com.website.ThoiTrangOnline.Controller;

import java.time.LocalDate;
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
import com.website.ThoiTrangOnline.ModelDto.TaiKhoanKhachHangRegisterDto;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Repository.TaiKhoanRepository;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
		
	@Autowired TaiKhoanRepository taikhoanRepository;
	@Autowired KhachHangRepository khachhangRepository;
	
	@GetMapping("/register")
	public String showRegisterView(Model model) {
		TaiKhoanKhachHangRegisterDto taikhoankhachhangregisterDto = new TaiKhoanKhachHangRegisterDto();
		model.addAttribute("taikhoankhachhangregisterDto", taikhoankhachhangregisterDto);
		return "registerview";
	}
	
	@PostMapping("/register")
	public String registerAcc(@Valid @ModelAttribute("taikhoankhachhangregisterDto") TaiKhoanKhachHangRegisterDto taikhoankhachhangregisterDto, BindingResult result, Model model) {
		
		if(result.hasFieldErrors("ten") 
		|| result.hasFieldErrors("tendangnhap")
		|| result.hasFieldErrors("matkhau")
		|| result.hasFieldErrors("diachi")
		|| result.hasFieldErrors("ngaysinh")
		|| result.hasFieldErrors("sodienthoai") ) {
	        return "registerview";
	    }
		
		String tendangnhap = taikhoankhachhangregisterDto.getTendangnhap();		
		String matkhau = taikhoankhachhangregisterDto.getMatkhau();
		String ten = taikhoankhachhangregisterDto.getTen();
		String diachi = taikhoankhachhangregisterDto.getDiachi();
		LocalDate ngaysinh = taikhoankhachhangregisterDto.getNgaysinh();
		String sodienthoai = taikhoankhachhangregisterDto.getSodienthoai();
		
		Optional<TaiKhoan> taikhoanfind = taikhoanRepository.findByTendangnhap(tendangnhap);
		
		if(!taikhoanfind.isEmpty()) {
			model.addAttribute("tendangnhapError", "Tên đăng nhập đã tồn tại!");
			return "registerview";
		}
		
		else if(matkhau.length() < 8) {
			model.addAttribute("matkhauError","Mật khẩu phải trên 8 kí tự!");
			return "registerview";
		}
		
		TaiKhoan taikhoan = new TaiKhoan();
		KhachHang khachhang = new KhachHang();
		
		taikhoan.setTendangnhap(tendangnhap);
		taikhoan.setMatkhau(matkhau);
		taikhoan.setLoai("khachhang");
		
		khachhang.setTen(ten);
		khachhang.setDiachi(diachi);
		khachhang.setNgaysinh(ngaysinh);
		khachhang.setSodienthoai(sodienthoai);
		khachhang.setTaikhoan(taikhoan);
		
		taikhoanRepository.save(taikhoan);
		khachhangRepository.save(khachhang);
		
		model.addAttribute("successMessage", "Đăng ký thành công!");
		TaiKhoanLoginDto taikhoanloginDto = new TaiKhoanLoginDto();
		model.addAttribute("taikhoanloginDto", taikhoanloginDto);
		return "loginview";
		
	}
	
}
