package com.website.ThoiTrangOnline.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.ModelDto.MatHangDto;
import com.website.ThoiTrangOnline.Repository.MatHangRepository;
import com.website.ThoiTrangOnline.Service.MatHangService;

@RestController
public class MatHangRestController {
	
	@Autowired MatHangRepository mathangRepository;
	@Autowired MatHangService mathangService;
	
	@GetMapping("/allmathang")
	public List<MatHangDto> showAllMatHang(){
		List<MatHang> mathangs = new ArrayList<MatHang>();
		mathangs = mathangRepository.findAll();	
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
		
		for (MatHang mathang : mathangs) {
			MatHangDto matHangDto = new MatHangDto();
			
			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));
			
			mathangDtos.add(matHangDto);
		}
		return mathangDtos;
	}
	
	@GetMapping("/mathanggoiy")
	public List<MatHangDto> showMatHangGoiY(){
		List<MatHang> mathangs = new ArrayList<MatHang>();
		mathangs = mathangRepository.findAll();	
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
		
		for (MatHang mathang : mathangs) {
			MatHangDto matHangDto = new MatHangDto();
			
			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));
			
			mathangDtos.add(matHangDto);
		}
		
		Collections.shuffle(mathangDtos);


        List<MatHangDto> goiy = mathangDtos.subList(0, Math.min(mathangDtos.size(), 12));
		return goiy;
	}
	
	@GetMapping("/mathangmoi")
	public List<MatHangDto> showMatHangMoi(){
		List<MatHang> mathangs = new ArrayList<MatHang>();
		mathangs = mathangRepository.findAll();	
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
		
		for (MatHang mathang : mathangs) {
			MatHangDto matHangDto = new MatHangDto();
			
			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));
			
			mathangDtos.add(matHangDto);
		}
		
		Collections.sort(mathangDtos, (o1, o2) -> o2.getId() - o1.getId());
		List<MatHangDto> mathangmoi = new ArrayList<>(mathangDtos.subList(0, Math.min(mathangDtos.size(),12)));
		return mathangmoi;
	}
	
	@GetMapping("/mathangbanchay")
	public List<MatHangDto> showMatHangBanChay(){
		List<MatHang> mathangs = new ArrayList<MatHang>();
		mathangs = mathangRepository.findAll();	
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
		
		for (MatHang mathang : mathangs) {
			MatHangDto matHangDto = new MatHangDto();
			
			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));
			
			mathangDtos.add(matHangDto);
		}
		Collections.sort(mathangDtos, (o1, o2) -> o2.getLuotban() - o1.getLuotban());
		List<MatHangDto> mathangDtobanchay = new ArrayList<>(mathangDtos.subList(0, Math.min(mathangDtos.size(), 12)));	
		return mathangDtobanchay;
	}
	@GetMapping("/timkiem")
	public List<MatHangDto> getMatHangbyTen(@RequestParam String key) {
		
		List<MatHang> mathangs = mathangRepository.findByTenContaining(key);
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
		
		for (MatHang mathang : mathangs) {
			MatHangDto matHangDto = new MatHangDto();
			
			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));
			
			mathangDtos.add(matHangDto);
		}
			
		return mathangDtos;
	}
}
