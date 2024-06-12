package com.website.ThoiTrangOnline.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="khachhang")
public class KhachHang extends NguoiDung{ 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taikhoan_id", nullable = false, referencedColumnName = "id")
	@JsonManagedReference
    private TaiKhoan taikhoan;
	
	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	@OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL)
	 private List<DonHang> donhang = new ArrayList<>();

	public List<DonHang> getDonhang() {
		return donhang;
	}

	public void setDonhang(List<DonHang> donhang) {
		this.donhang = donhang;
	}
	
}
