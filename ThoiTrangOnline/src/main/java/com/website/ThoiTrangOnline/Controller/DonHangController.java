package com.website.ThoiTrangOnline.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.TrangThaiDH;
import com.website.ThoiTrangOnline.ModelDto.DonHangDto;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Repository.TrangThaiDHRepository;

@RestController
public class DonHangController {
	
	@Autowired DonHangRepository donhangRepository;
	@Autowired KhachHangRepository khachhangRepository;
	@Autowired TrangThaiDHRepository trangthaidhRepository;
	
	@GetMapping("/alldonhang")
	public List<DonHangDto>  getAllDonHang( @RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
 		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id);
		KhachHang khachhang = new KhachHang();
		khachhang = khachhangfind.get();
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByKhachhang(khachhang);
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
	
	@GetMapping("/donhang1")
	public List<DonHangDto>  getDonHangChoXacNhan(@RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
 		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id);
		KhachHang khachhang = new KhachHang();
		khachhang = khachhangfind.get();
		
		Optional<TrangThaiDH> trangthaidh_find = trangthaidhRepository.findById(1);
		TrangThaiDH trangthaidh = new TrangThaiDH();
		trangthaidh = trangthaidh_find.get();
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByKhachhangAndTrangthaidh(khachhang, trangthaidh);
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
	
	@GetMapping("/donhang2")
	public List<DonHangDto>  getDonHangDangGiao(@RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
 		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id);
		KhachHang khachhang = new KhachHang();
		khachhang = khachhangfind.get();
		
		Optional<TrangThaiDH> trangthaidh_find = trangthaidhRepository.findById(2);
		TrangThaiDH trangthaidh = new TrangThaiDH();
		trangthaidh = trangthaidh_find.get();
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByKhachhangAndTrangthaidh(khachhang, trangthaidh);
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
	
	@GetMapping("/donhang3")
	public List<DonHangDto>  getDonHangHoanThanh(@RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
 		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id);
		KhachHang khachhang = new KhachHang();
		khachhang = khachhangfind.get();
		
		Optional<TrangThaiDH> trangthaidh_find = trangthaidhRepository.findById(3);
		TrangThaiDH trangthaidh = new TrangThaiDH();
		trangthaidh = trangthaidh_find.get();
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByKhachhangAndTrangthaidh(khachhang, trangthaidh);
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
	
	@GetMapping("/donhang4")
	public List<DonHangDto>  getDonHangDaHuy(@RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
 		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id);
		KhachHang khachhang = new KhachHang();
		khachhang = khachhangfind.get();
		
		Optional<TrangThaiDH> trangthaidh_find = trangthaidhRepository.findById(4);
		TrangThaiDH trangthaidh = new TrangThaiDH();
		trangthaidh = trangthaidh_find.get();
		
		List<DonHang> donhangs = new ArrayList<DonHang>();
		
		donhangs = donhangRepository.findByKhachhangAndTrangthaidh(khachhang, trangthaidh);
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
