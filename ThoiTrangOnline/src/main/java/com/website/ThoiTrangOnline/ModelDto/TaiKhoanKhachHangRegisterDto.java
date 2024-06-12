package com.website.ThoiTrangOnline.ModelDto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TaiKhoanKhachHangRegisterDto {
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String ten;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String tendangnhap;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String matkhau;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String diachi;
	
	@NotNull(message = "Vui lòng nhập đầy đủ thông tin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaysinh;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin")
	private String sodienthoai;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public LocalDate getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	
	
	
}
