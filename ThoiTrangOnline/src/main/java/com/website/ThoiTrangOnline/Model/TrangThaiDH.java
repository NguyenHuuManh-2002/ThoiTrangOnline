package com.website.ThoiTrangOnline.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="trangthaidh")
public class TrangThaiDH {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ten;
	
	@OneToMany(mappedBy = "trangthaidh", cascade = CascadeType.ALL)
	 private List<DonHang> donhang = new ArrayList<>();

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

	public List<DonHang> getDonhang() {
		return donhang;
	}

	public void setDonhang(List<DonHang> donhang) {
		this.donhang = donhang;
	}
	
	
}
