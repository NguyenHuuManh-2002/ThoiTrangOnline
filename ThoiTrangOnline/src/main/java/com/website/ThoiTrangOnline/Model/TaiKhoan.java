package com.website.ThoiTrangOnline.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    private String tendangnhap;
    private String matkhau;
    private String loai;
   
    @OneToOne(mappedBy = "taikhoan")
    @JsonBackReference
    private KhachHang khachhang;
    
    @OneToOne(mappedBy = "taikhoan")
    @JsonBackReference
    private NhanVien nhanvien;
    
    @OneToOne(mappedBy = "taikhoan")
    @JsonBackReference
    private QuanLy quanly;

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public QuanLy getQuanly() {
		return quanly;
	}

	public void setQuanly(QuanLy quanly) {
		this.quanly = quanly;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}
    
    
}
