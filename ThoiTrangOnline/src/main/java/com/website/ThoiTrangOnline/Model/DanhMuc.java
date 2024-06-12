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
@Table(name="danhmuc")
public class DanhMuc {
			
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String imgdanhmuc;
	private String ten;
	
	@OneToMany(mappedBy = "danhmuc", cascade = CascadeType.ALL)
	 private List<MatHang> mathang = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgdanhmuc() {
		return imgdanhmuc;
	}

	public void setImgdanhmuc(String imgdanhmuc) {
		this.imgdanhmuc = imgdanhmuc;
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
