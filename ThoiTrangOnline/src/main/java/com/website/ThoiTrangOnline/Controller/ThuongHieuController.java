package com.website.ThoiTrangOnline.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.ModelDto.ThuongHieuDto;
import com.website.ThoiTrangOnline.Repository.ThuongHieuRepository;

@RestController
public class ThuongHieuController {
	
	@Autowired ThuongHieuRepository thuonghieuRepository;
	
	@GetMapping("/thuonghieu")
	public List<ThuongHieuDto> getThuongHieu(){
		
		
		List<ThuongHieu> thuonghieus = new ArrayList<ThuongHieu>();
		thuonghieus = thuonghieuRepository.findAll();
		
		List<ThuongHieuDto> thuonghieuDtos = new ArrayList<ThuongHieuDto>();
		
		for(ThuongHieu thuonghieu : thuonghieus) {
			ThuongHieuDto thuonghieuDto = new ThuongHieuDto();
			
			thuonghieuDto.setId(thuonghieu.getId());
			thuonghieuDto.setTen(thuonghieu.getTen());
			thuonghieuDto.setImgthuonghieu(thuonghieu.getImgthuonghieu());
			
			thuonghieuDtos.add(thuonghieuDto);
		
		}
		
		return thuonghieuDtos;
	}

}


