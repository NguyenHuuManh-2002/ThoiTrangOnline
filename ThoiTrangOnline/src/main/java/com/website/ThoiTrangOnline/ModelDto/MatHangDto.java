package com.website.ThoiTrangOnline.ModelDto;


public class MatHangDto {
	private int id;
	private String ten;
	private int gia;
	private String imgmathang;
	private int luotban;
	private int conlai;
	private String danhmuc;
	private String thuonghieu;
	
	
	
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
	public int getLuotban() {
		return luotban;
	}
	public void setLuotban(int luotban) {
		this.luotban = luotban;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getImgmathang() {
		return imgmathang;
	}
	public void setImgmathang(String imgmathang) {
		this.imgmathang = imgmathang;
	}
	
}