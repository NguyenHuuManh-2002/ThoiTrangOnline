package com.website.ThoiTrangOnline.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.Model.TrangThaiDH;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
	
	List<DonHang> findByKhachhang(KhachHang khachhang); 
	List<DonHang> findByKhachhangAndTrangthaidh(KhachHang khachhang, TrangThaiDH trangthaidh); 
	List<DonHang> findByMathangAndTrangthaidh_id(MatHang mathang, int trangthaidh);
}
