package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.TaiKhoan;


public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer>{
	Optional<TaiKhoan> findByTendangnhap(String tendangnhap);
}
