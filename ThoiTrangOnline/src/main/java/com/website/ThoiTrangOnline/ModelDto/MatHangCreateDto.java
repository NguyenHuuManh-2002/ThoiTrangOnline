package com.website.ThoiTrangOnline.ModelDto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MatHangCreateDto {

	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin!")
	private String ten;
	
	private int gia;
	private int conlai;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin!")
	private String danhmuc;
	
	@NotEmpty(message = "Vui lòng nhập đầy đủ thông tin!")
	private String thuonghieu;
	
	private MultipartFile imageFile;
	
	@Size(min = 10, message = "Yêu cầu nhập tối thiểu 10 kí tự")
	@Size(max = 2000, message = "Yêu cầu nhập tối đa 1000 kí tự")
	private String mota;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getConlai() {
		return conlai;
	}

	public void setConlai(int conlai) {
		this.conlai = conlai;
	}

	public String getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(String danhmuc) {
		this.danhmuc = danhmuc;
	}

	public String getThuonghieu() {
		return thuonghieu;
	}

	public void setThuonghieu(String thuonghieu) {
		this.thuonghieu = thuonghieu;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
