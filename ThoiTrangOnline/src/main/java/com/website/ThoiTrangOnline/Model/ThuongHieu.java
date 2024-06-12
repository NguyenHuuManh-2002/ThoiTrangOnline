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
@Table(name="thuonghieu")
public class ThuongHieu {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String imgthuonghieu;
	private String ten;
	
	@OneToMany(mappedBy = "thuonghieu", cascade = CascadeType.ALL)
	 private List<MatHang> mathang = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgthuonghieu() {
		return imgthuonghieu;
	}

	public void setImgthuonghieu(String imgthuonghieu) {
		this.imgthuonghieu = imgthuonghieu;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<MatHang> getMathang() {
		return mathang;
	}

	public void setMathang(List<MatHang> mathang) {
		this.mathang = mathang;
	}
	
	
}
