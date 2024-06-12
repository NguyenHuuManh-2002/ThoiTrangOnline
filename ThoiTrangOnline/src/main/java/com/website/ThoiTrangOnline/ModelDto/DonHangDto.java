package com.website.ThoiTrangOnline.ModelDto;

import java.time.LocalDate;

public class DonHangDto {
	
	private int id;
	private int id_khachhang;
	private int id_mathang;
	private String imgmathang;
	private String ten;
	private int soluong;
	private int gia;
	private int tongtien;
	private int trangthaidh_id;
	private String trangthaidh;
	private LocalDate ngaydat;
	private int phuongthuctt;
	private int conlai;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConlai() {
		return conlai;
	}
	public void setConlai(int conlai) {
		this.conlai = conlai;
	}
	public void setId_khachhang(int id_khachhang) {
		this.id_khachhang = id_khachhang;
	}
	public int getId_khachhang() {
		return id_khachhang;
	}
	public void setId_khchhang(int id_khachhang) {
		this.id_khachhang = id_khachhang;
	}
	public int getPhuongthuctt() {
		return phuongthuctt;
	}
	public void setPhuongthuctt(int phuongthuctt) {
		this.phuongthuctt = phuongthuctt;
	}
	public int getId_mathang() {
		return id_mathang;
	}
	public void setId_mathang(int id_mathang) {
		this.id_mathang = id_mathang;
	}
	public LocalDate getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(LocalDate ngaydat) {
		this.ngaydat = ngaydat;
	}
	public String getImgmathang() {
		return imgmathang;
	}
	public void setImgmathang(String imgmathang) {
		this.imgmathang = imgmathang;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public int getTrangthaidh_id() {
		return trangthaidh_id;
	}
	public void setTrangthaidh_id(int trangthaidh_id) {
		this.trangthaidh_id = trangthaidh_id;
	}
	public String getTrangthaidh() {
		return trangthaidh;
	}
	public void setTrangthaidh(String trangthaidh) {
		this.trangthaidh = trangthaidh;
	}
	
	
}
