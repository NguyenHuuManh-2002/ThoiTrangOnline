package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.DanhMuc;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer>{
	Optional<DanhMuc> findById(int id);
	Optional<DanhMuc> findByTen(String ten);
}
