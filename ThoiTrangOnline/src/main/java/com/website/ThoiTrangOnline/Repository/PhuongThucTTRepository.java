package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.PhuongThucTT;

public interface PhuongThucTTRepository extends JpaRepository<PhuongThucTT, Integer>{

	Optional<PhuongThucTT> findById(int id);
}
