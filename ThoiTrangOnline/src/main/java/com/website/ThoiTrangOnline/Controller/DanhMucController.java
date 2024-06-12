package com.website.ThoiTrangOnline.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.ModelDto.DanhMucDto;
import com.website.ThoiTrangOnline.Repository.DanhMucRepository;

@RestController
public class DanhMucController {
			
	@Autowired DanhMucRepository danhmucRepository;
	
	@GetMapping("/danhmuc")
	public List<DanhMucDto> getDanhMuc() {
		
		List<DanhMuc> danhmucs = new ArrayList<DanhMuc>();
		
		danhmucs = danhmucRepository.findAll();
		
		List<DanhMucDto> danhmucDtos = new ArrayList<DanhMucDto>();
		
		for(DanhMuc danhmuc : danhmucs) {
			DanhMucDto danhmucDto = new DanhMucDto();
			
			danhmucDto.setId(danhmuc.getId());
			danhmucDto.setTen(danhmuc.getTen());
			danhmucDto.setImgdanhmuc(danhmuc.getImgdanhmuc());
			
			danhmucDtos.add(danhmucDto);
		}
		return danhmucDtos;
	}
}
