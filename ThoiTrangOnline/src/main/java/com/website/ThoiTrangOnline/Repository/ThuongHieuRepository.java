package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer>{

	Optional<ThuongHieu> findById(int id);
	Optional<ThuongHieu> findByTen(String ten);
}
