package com.website.ThoiTrangOnline.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.ModelDto.DonHangDto;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Repository.TrangThaiDHRepository;

@RestController
public class NhanVienRestController {
	
	@Autowired DonHangRepository donhangRepository;
	@Autowired KhachHangRepository khachhangRepository;
	@Autowired TrangThaiDHRepository trangthaidhRepository;
	
	@GetMapping("/nhanvien/alldonhang")
	public List<DonHangDto> getAllDonHang() {

		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findAll();
		Collections.sort(donhangs, (o1, o2) -> o2.getId() - o1.getId());
		List<DonHangDto> donhangDtos = new ArrayList<DonHangDto>();
		
		for(DonHang donhang : donhangs) {
			
			DonHangDto donhangDto = new DonHangDto();
			donhangDto.setId(donhang.getId());
			donhangDto.setId_mathang(donhang.getMathang().getId());
			donhangDto.setImgmathang(donhang.getMathang().getImgmathang());
			donhangDto.setTen(donhang.getMathang().getTen());
			donhangDto.setSoluong(donhang.getSoluong());
			donhangDto.setGia(donhang.getMathang().getGia());
			donhangDto.setTongtien(donhang.getTongtien());
			donhangDto.setTrangthaidh_id(donhang.getTrangthaidh().getId());
			donhangDto.setTrangthaidh(donhang.getTrangthaidh().getTen());
			donhangDto.setNgaydat(donhang.getNgaydat());			
			donhangDtos.add(donhangDto);
		}	
		return donhangDtos;
	}
	
	@GetMapping("/nhanvien/donhang1")
	public List<DonHangDto> getDonHangChoXacNhan() {
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByTrangthaidh_id(1);
		Collections.sort(donhangs, (o1, o2) -> o2.getId() - o1.getId());
		List<DonHangDto> donhangDtos = new ArrayList<DonHangDto>();
		
		for(DonHang donhang : donhangs) {
			
			DonHangDto donhangDto = new DonHangDto();
			donhangDto.setId(donhang.getId());
			donhangDto.setId_mathang(donhang.getMathang().getId());
			donhangDto.setImgmathang(donhang.getMathang().getImgmathang());
			donhangDto.setTen(donhang.getMathang().getTen());
			donhangDto.setSoluong(donhang.getSoluong());
			donhangDto.setGia(donhang.getMathang().getGia());
			donhangDto.setTongtien(donhang.getTongtien());
			donhangDto.setTrangthaidh_id(donhang.getTrangthaidh().getId());
			donhangDto.setTrangthaidh(donhang.getTrangthaidh().getTen());
			donhangDto.setNgaydat(donhang.getNgaydat());			
			donhangDtos.add(donhangDto);
		}	
		return donhangDtos;
	}
	
	@GetMapping("/nhanvien/donhang2")
	public List<DonHangDto> getDonHangDangGiao() {
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByTrangthaidh_id(2);
		Collections.sort(donhangs, (o1, o2) -> o2.getId() - o1.getId());
		List<DonHangDto> donhangDtos = new ArrayList<DonHangDto>();
		
		for(DonHang donhang : donhangs) {
			
			DonHangDto donhangDto = new DonHangDto();
			donhangDto.setId(donhang.getId());
			donhangDto.setId_mathang(donhang.getMathang().getId());
			donhangDto.setImgmathang(donhang.getMathang().getImgmathang());
			donhangDto.setTen(donhang.getMathang().getTen());
			donhangDto.setSoluong(donhang.getSoluong());
			donhangDto.setGia(donhang.getMathang().getGia());
			donhangDto.setTongtien(donhang.getTongtien());
			donhangDto.setTrangthaidh_id(donhang.getTrangthaidh().getId());
			donhangDto.setTrangthaidh(donhang.getTrangthaidh().getTen());
			donhangDto.setNgaydat(donhang.getNgaydat());			
			donhangDtos.add(donhangDto);
		}	
		return donhangDtos;
	}
	
	@GetMapping("/nhanvien/donhang3")
	public List<DonHangDto> getDonHangHoanThanh() {
		
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByTrangthaidh_id(3);
		Collections.sort(donhangs, (o1, o2) -> o2.getId() - o1.getId());
		List<DonHangDto> donhangDtos = new ArrayList<DonHangDto>();
		
		for(DonHang donhang : donhangs) {
			
			DonHangDto donhangDto = new DonHangDto();
			donhangDto.setId(donhang.getId());
			donhangDto.setId_mathang(donhang.getMathang().getId());
			donhangDto.setImgmathang(donhang.getMathang().getImgmathang());
			donhangDto.setTen(donhang.getMathang().getTen());
			donhangDto.setSoluong(donhang.getSoluong());
			donhangDto.setGia(donhang.getMathang().getGia());
			donhangDto.setTongtien(donhang.getTongtien());
			donhangDto.setTrangthaidh_id(donhang.getTrangthaidh().getId());
			donhangDto.setTrangthaidh(donhang.getTrangthaidh().getTen());
			donhangDto.setNgaydat(donhang.getNgaydat());			
			donhangDtos.add(donhangDto);
		}	
		return donhangDtos;
	}
	
	@GetMapping("/nhanvien/donhang4")
	public List<DonHangDto> getDonHangDaHuy() {
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByTrangthaidh_id(4);
		Collections.sort(donhangs, (o1, o2) -> o2.getId() - o1.getId());
		List<DonHangDto> donhangDtos = new ArrayList<DonHangDto>();
		
		for(DonHang donhang : donhangs) {
			
			DonHangDto donhangDto = new DonHangDto();
			donhangDto.setId(donhang.getId());
			donhangDto.setId_mathang(donhang.getMathang().getId());
			donhangDto.setImgmathang(donhang.getMathang().getImgmathang());
			donhangDto.setTen(donhang.getMathang().getTen());
			donhangDto.setSoluong(donhang.getSoluong());
			donhangDto.setGia(donhang.getMathang().getGia());
			donhangDto.setTongtien(donhang.getTongtien());
			donhangDto.setTrangthaidh_id(donhang.getTrangthaidh().getId());
			donhangDto.setTrangthaidh(donhang.getTrangthaidh().getTen());
			donhangDto.setNgaydat(donhang.getNgaydat());			
			donhangDtos.add(donhangDto);
		}	
		return donhangDtos;
	}
}
