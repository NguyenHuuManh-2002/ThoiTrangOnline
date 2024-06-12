package com.website.ThoiTrangOnline.Model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mathang")
public class MatHang {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ten;
	private int gia;
	private int soluong;
	
	@ManyToOne
    @JoinColumn(name = "danhmuc_id", nullable = false)
    private DanhMuc danhmuc;
	
	
	@ManyToOne
    @JoinColumn(name = "thuonghieu_id", nullable = false)
    private ThuongHieu thuonghieu;
	
	private LocalDate ngaytao;	
	private String imgmathang;
	
	
	@Column(columnDefinition = "TEXT")
	private String mota;


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


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public DanhMuc getDanhmuc() {
		return danhmuc;
	}


	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}


	public ThuongHieu getThuonghieu() {
		return thuonghieu;
	}


	public void setThuonghieu(ThuongHieu thuonghieu) {
		this.thuonghieu = thuonghieu;
	}


	public LocalDate getNgaytao() {
		return ngaytao;
	}


	public void setNgaytao(LocalDate ngaytao) {
		this.ngaytao = ngaytao;
	}


	public String getImgmathang() {
		return imgmathang;
	}


	public void setImgmathang(String imgathang) {
		this.imgmathang = imgathang;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}
	
	
}
