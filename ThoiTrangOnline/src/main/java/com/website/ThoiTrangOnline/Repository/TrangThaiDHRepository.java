package com.website.ThoiTrangOnline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ThoiTrangOnline.Model.TrangThaiDH;

public interface TrangThaiDHRepository extends JpaRepository<TrangThaiDH, Integer> {

	Optional<TrangThaiDH> findById(int id);
}
