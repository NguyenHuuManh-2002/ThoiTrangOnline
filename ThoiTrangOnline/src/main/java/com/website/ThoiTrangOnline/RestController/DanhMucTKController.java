package com.website.ThoiTrangOnline.RestController;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.ModelDto.DanhMucDto;
import com.website.ThoiTrangOnline.Repository.DanhMucRepository;
import com.website.ThoiTrangOnline.Service.DanhMucService;

@RestController
public class DanhMucTKController {
	@Autowired
	private DanhMucService danhmucService;

	@Autowired
	private DanhMucRepository danhmucRepository;

	@GetMapping("/danhmuctk")
	public List<DanhMucDto> getAllDanhmuc() {

		List<DanhMuc> danhmucs = danhmucRepository.findAll();
		if (danhmucs == null || danhmucs.isEmpty()) {
			return (List<DanhMucDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No categories found");
		}

		List<DanhMucDto> danhmucDtos = new ArrayList<DanhMucDto>();

		for (DanhMuc danhmuc : danhmucs) {

			int tongsoluong = danhmucService.getTongLuotBanDM(danhmuc);
			int tongdoanhthu = danhmucService.getTongDoanhThuDM(danhmuc);

			DanhMucDto danhmucDto = new DanhMucDto();
			danhmucDto.setId(danhmuc.getId());
			danhmucDto.setTen(danhmuc.getTen());
			danhmucDto.setTongsoluong(tongsoluong);
			danhmucDto.setTongdoanhthu(tongdoanhthu);
			danhmucDtos.add(danhmucDto);
		}
		return danhmucDtos;
	}

	@GetMapping("/danhmucmonthyear")
	public List<DanhMucDto> getAllDanhMucwithMonthYear(@RequestParam String month, @RequestParam String year) {
		List<DanhMuc> danhmucs = danhmucRepository.findAll();

		if (danhmucs == null || danhmucs.isEmpty()) {
			return (List<DanhMucDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
		}

		int monthINT = Integer.parseInt(month);
		int yearINT = Integer.parseInt(year);
		YearMonth yearMonth = YearMonth.of(yearINT, monthINT);

		LocalDate start = LocalDate.of(yearINT, monthINT, 1);
		LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());

		List<DanhMucDto> danhmucDtos = new ArrayList<DanhMucDto>();

		for (DanhMuc danhmuc : danhmucs) {
			int tongsoluong = danhmucService.getTongLuotBanwithMonthYearDM(danhmuc, start, end);
			int tongdoanhthu = danhmucService.getTongDoanhThuwithMonthYearDM(danhmuc, start, end);

			DanhMucDto danhmucDto = new DanhMucDto();
			danhmucDto.setId(danhmuc.getId());
			danhmucDto.setTen(danhmuc.getTen());
			danhmucDto.setTongsoluong(tongsoluong);
			danhmucDto.setTongdoanhthu(tongdoanhthu);
			danhmucDtos.add(danhmucDto);
		}
		return danhmucDtos;
	}

	@GetMapping("/danhmucmonth")
	public List<DanhMucDto> getAllDAnhMucwithMonth(@RequestParam String month) {
		List<DanhMuc> danhmucs = danhmucRepository.findAll();

		if (danhmucs == null || danhmucs.isEmpty()) {
			return (List<DanhMucDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
		}

		int monthINT = Integer.parseInt(month);
		List<DanhMucDto> danhmucDtos = new ArrayList<DanhMucDto>();

		for (DanhMuc danhmuc : danhmucs) {
			int tongsoluong = danhmucService.getTongLuotBanwithMonthDM(danhmuc, monthINT);
			int tongdoanhthu = danhmucService.getTongDoanhThuwithMonthDM(danhmuc, monthINT);

			DanhMucDto danhmucDto = new DanhMucDto();
			danhmucDto.setId(danhmuc.getId());
			danhmucDto.setTen(danhmuc.getTen());
			danhmucDto.setTongsoluong(tongsoluong);
			danhmucDto.setTongdoanhthu(tongdoanhthu);
			danhmucDtos.add(danhmucDto);
		}
		return danhmucDtos;
	}

	@GetMapping("/danhmucyear")
	public List<DanhMucDto> getAllDanhMucwithYear(@RequestParam String year) {
		List<DanhMuc> danhmucs = danhmucRepository.findAll();

		if (danhmucs == null || danhmucs.isEmpty()) {
			return (List<DanhMucDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
		}

		int yearINT = Integer.parseInt(year);
		List<DanhMucDto> danhmucDtos = new ArrayList<DanhMucDto>();

		for (DanhMuc danhmuc : danhmucs) {
			int tongsoluong = danhmucService.getTongLuotBanwithYearDM(danhmuc, yearINT);
			int tongdoanhthu = danhmucService.getTongDoanhThuwithYearDM(danhmuc, yearINT);

			DanhMucDto danhmucDto = new DanhMucDto();
			danhmucDto.setId(danhmuc.getId());
			danhmucDto.setTen(danhmuc.getTen());
			danhmucDto.setTongsoluong(tongsoluong);
			danhmucDto.setTongdoanhthu(tongdoanhthu);
			danhmucDtos.add(danhmucDto);
		}
		return danhmucDtos;
	}

}
