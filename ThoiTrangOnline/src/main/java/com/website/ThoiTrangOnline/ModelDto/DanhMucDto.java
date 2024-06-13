package com.website.ThoiTrangOnline.ModelDto;

public class DanhMucDto {
	private int id;
	private String ten;
	private String imgdanhmuc;
	private int tongsoluong;
	private int tongdoanhthu;
	
	public int getTongsoluong() {
		return tongsoluong;
	}
	public void setTongsoluong(int tongsoluong) {
		this.tongsoluong = tongsoluong;
	}
	public int getTongdoanhthu() {
		return tongdoanhthu;
	}
	public void setTongdoanhthu(int tongdoanhthu) {
		this.tongdoanhthu = tongdoanhthu;
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
	public String getImgdanhmuc() {
		return imgdanhmuc;
	}
	public void setImgdanhmuc(String imgdanhmuc) {
		this.imgdanhmuc = imgdanhmuc;
	}
	
	
}
