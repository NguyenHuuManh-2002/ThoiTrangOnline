package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.TaiKhoan;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{

	Optional<KhachHang> findById(int id);
	Optional<KhachHang> findByTaikhoan(TaiKhoan taikhoan);
}
