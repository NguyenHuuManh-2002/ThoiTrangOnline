package com.website.ThoiTrangOnline.ModelDto;

public class KhachHangDto {
	
	private int id;
	private String ten;
	private int tongdonhang;
	private int tongmathang;	
	private double somathangtb;
	private int giatridontb;
	private int tongchitieu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTongdonhang() {
		return tongdonhang;
	}
	public void setTongdonhang(int tongdonhang) {
		this.tongdonhang = tongdonhang;
	}
	public int getTongmathang() {
		return tongmathang;
	}
	public void setTongmathang(int tongmathang) {
		this.tongmathang = tongmathang;
	}
	public double getSomathangtb() {
		return somathangtb;
	}
	public void setSomathangtb(double somathangtb) {
		this.somathangtb = somathangtb;
	}
	public double getGiatridontb() {
		return giatridontb;
	}
	public void setGiatridontb(int giatridontb) {
		this.giatridontb = giatridontb;
	}
	public int getTongchitieu() {
		return tongchitieu;
	}
	public void setTongchitieu(int tongchitieu) {
		this.tongchitieu = tongchitieu;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
}
