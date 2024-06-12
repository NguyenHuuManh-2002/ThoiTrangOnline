package com.website.ThoiTrangOnline.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.Model.MatHang;

public interface MatHangRepository extends JpaRepository<MatHang, Integer>{
	Optional<MatHang> findById(int id);
	List<MatHang> findAllByDanhmuc(DanhMuc danhmuc);
	List<MatHang> findByDanhmuc_id(int danhmuc_id);
	List<MatHang> findByThuonghieu_id(int thuonghieu_id);
	List<MatHang> findByTenContaining(String keyword);

}
