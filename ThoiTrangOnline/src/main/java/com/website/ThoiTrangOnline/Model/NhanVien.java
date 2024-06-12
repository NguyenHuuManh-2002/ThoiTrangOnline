package com.website.ThoiTrangOnline.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="nhanvien")
public class NhanVien extends NguoiDung{	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taikhoan_id", nullable = false, referencedColumnName = "id")
	@JsonManagedReference
    private TaiKhoan taikhoan;
	
	private String vitri;
	
	
	
	public String getVitri() {
		return vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	
}
