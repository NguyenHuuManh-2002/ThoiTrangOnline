package com.website.ThoiTrangOnline.ModelDto;

import jakarta.validation.constraints.NotEmpty;

public class TaiKhoanLoginDto { 
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String tendangnhap;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String matkhau;

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	 
} 
