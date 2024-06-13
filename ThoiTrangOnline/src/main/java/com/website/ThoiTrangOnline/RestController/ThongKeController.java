package com.website.ThoiTrangOnline.RestController;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.PhuongThucTT;
import com.website.ThoiTrangOnline.ModelDto.DoanhThuLuotBanDto;
import com.website.ThoiTrangOnline.ModelDto.PhuongThucTTDto;
import com.website.ThoiTrangOnline.ModelDto.SoDonHangDto;
import com.website.ThoiTrangOnline.Repository.PhuongThucTTRepository;
import com.website.ThoiTrangOnline.Service.ThongKeService;

@RestController
public class ThongKeController {

	@Autowired
	ThongKeService thongkeService;

	@Autowired
	PhuongThucTTRepository ptttRepository;

	@GetMapping("/doanhthu")
	public DoanhThuLuotBanDto getDoanhThu() {

		DoanhThuLuotBanDto doanhthuluotbanDto = new DoanhThuLuotBanDto();

		LocalDate currentDate = LocalDate.now();

		// Lấy tháng hiện tại
		int currentMonth = currentDate.getMonthValue();

		int currentMonthbefore = currentMonth - 1;

		// Lấy năm hiện tại
		int currentYear = currentDate.getYear();

		YearMonth yearMonth = YearMonth.of(currentYear, currentMonth);
		LocalDate start = LocalDate.of(currentYear, currentMonth, 1);
		LocalDate end = LocalDate.of(currentYear, currentMonth, yearMonth.lengthOfMonth());

		YearMonth yearMonthbefore = YearMonth.of(currentYear, currentMonthbefore);
		LocalDate startbefore = LocalDate.of(currentYear, currentMonthbefore, 1);
		LocalDate endbefore = LocalDate.of(currentYear, currentMonthbefore, yearMonthbefore.lengthOfMonth());

		int doanhthu = thongkeService.getTongDoanhThuMonth(start, end);
		int sodonhang = thongkeService.getTongDonHangMonth(start, end);
		int somathang = thongkeService.getTongMatHangMonth(start, end);

		int doanhthubefore = thongkeService.getTongDoanhThuMonth(startbefore, endbefore);
		int sodonhangbefore = thongkeService.getTongDonHangMonth(startbefore, endbefore);
		int somathangbefore = thongkeService.getTongMatHangMonth(startbefore, endbefore);

		doanhthuluotbanDto.setNgayhientai(currentDate);
		doanhthuluotbanDto.setDoanhthu(doanhthu);
		doanhthuluotbanDto.setSodonhang(sodonhang);
		doanhthuluotbanDto.setSomathang(somathang);
		
		if (doanhthubefore == 0) {
			doanhthuluotbanDto.setTiledoanhthu(0);
		} else {
			doanhthuluotbanDto.setTiledoanhthu(Math.round(((double) doanhthu * 100 / doanhthubefore) * 100.0) / 100.0);
		}

		if (sodonhangbefore == 0) {
			doanhthuluotbanDto.setTilesodonhang(0);
		} else {
			doanhthuluotbanDto.setTilesodonhang(Math.round(((double) sodonhang * 100 / sodonhangbefore) * 100.0) / 100.0);
		}
		if (somathangbefore == 0) {
			doanhthuluotbanDto.setTilesomathang(0);
		}

		else {
			doanhthuluotbanDto.setTilesomathang(Math.round(((double) somathang * 100 / somathangbefore) * 100.0) / 100.0);
		}

		return doanhthuluotbanDto;
	}

	@GetMapping("/donhang")
	public SoDonHangDto getSoLuongDonHang() {

		SoDonHangDto soluongdonhang = new SoDonHangDto();

		int n1 = thongkeService.getSoDonHangNhoHon(100000);
		int n2 = thongkeService.getSoDonHangTrongKhoang(100000, 300000);
		int n3 = thongkeService.getSoDonHangTrongKhoang(300001, 500000);
		int n4 = thongkeService.getSoDonHangTrongKhoang(500001, 1000000);
		int n5 = thongkeService.getSoDonHangTrongKhoang(1000001, 2000000);
		int n6 = thongkeService.getSoDonHangLonHon(2000000);

		soluongdonhang.setN1(n1);
		soluongdonhang.setN2(n2);
		soluongdonhang.setN3(n3);
		soluongdonhang.setN4(n4);
		soluongdonhang.setN5(n5);
		soluongdonhang.setN6(n6);

		return soluongdonhang;
	}

	@GetMapping("/donhangmonthyear")
	public SoDonHangDto getSoLuongDonHangMonthYear(@RequestParam String month, @RequestParam String year) {

		int monthINT = Integer.parseInt(month);
		int yearINT = Integer.parseInt(year);
		YearMonth yearMonth = YearMonth.of(yearINT, monthINT);

		LocalDate start = LocalDate.of(yearINT, monthINT, 1);
		LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());

		SoDonHangDto soluongdonhang = new SoDonHangDto();

		int n1 = thongkeService.getSoDonHangNhoHonwithMonthYear(100000, start, end);
		int n2 = thongkeService.getSoDonHangTrongKhoangwithMonthYear(100000, 300000, start, end);
		int n3 = thongkeService.getSoDonHangTrongKhoangwithMonthYear(300001, 500000, start, end);
		int n4 = thongkeService.getSoDonHangTrongKhoangwithMonthYear(500001, 1000000, start, end);
		int n5 = thongkeService.getSoDonHangTrongKhoangwithMonthYear(1000001, 2000000, start, end);
		int n6 = thongkeService.getSoDonHangLonHonwithMonthYear(2000000, start, end);

		soluongdonhang.setN1(n1);
		soluongdonhang.setN2(n2);
		soluongdonhang.setN3(n3);
		soluongdonhang.setN4(n4);
		soluongdonhang.setN5(n5);
		soluongdonhang.setN6(n6);

		return soluongdonhang;
	}

	@GetMapping("/donhangmonth")
	public SoDonHangDto getSoLuongDonHangMonth(int month) {

		SoDonHangDto soluongdonhang = new SoDonHangDto();

		int n1 = thongkeService.getSoDonHangNhoHonwithMonth(100000, month);
		int n2 = thongkeService.getSoDonHangTrongKhoangwithMonth(100000, 300000, month);
		int n3 = thongkeService.getSoDonHangTrongKhoangwithMonth(300001, 500000, month);
		int n4 = thongkeService.getSoDonHangTrongKhoangwithMonth(500001, 1000000, month);
		int n5 = thongkeService.getSoDonHangTrongKhoangwithMonth(1000001, 2000000, month);
		int n6 = thongkeService.getSoDonHangLonHonwithMonth(2000000, month);

		soluongdonhang.setN1(n1);
		soluongdonhang.setN2(n2);
		soluongdonhang.setN3(n3);
		soluongdonhang.setN4(n4);
		soluongdonhang.setN5(n5);
		soluongdonhang.setN6(n6);

		return soluongdonhang;
	}

	@GetMapping("/donhangyear")
	public SoDonHangDto getSoLuongDonHangYear(int year) {

		SoDonHangDto soluongdonhang = new SoDonHangDto();

		int n1 = thongkeService.getSoDonHangNhoHonwithYear(100000, year);
		int n2 = thongkeService.getSoDonHangTrongKhoangwithYear(100000, 300000, year);
		int n3 = thongkeService.getSoDonHangTrongKhoangwithYear(300001, 500000, year);
		int n4 = thongkeService.getSoDonHangTrongKhoangwithYear(500001, 1000000, year);
		int n5 = thongkeService.getSoDonHangTrongKhoangwithYear(1000001, 2000000, year);
		int n6 = thongkeService.getSoDonHangLonHonwithYear(2000000, year);

		soluongdonhang.setN1(n1);
		soluongdonhang.setN2(n2);
		soluongdonhang.setN3(n3);
		soluongdonhang.setN4(n4);
		soluongdonhang.setN5(n5);
		soluongdonhang.setN6(n6);

		return soluongdonhang;
	}

	@GetMapping("/pttt")
	public List<PhuongThucTTDto> getSoLuongDonHangTheoPTTT() {

		List<PhuongThucTTDto> ptttDtos = new ArrayList<PhuongThucTTDto>();
		List<PhuongThucTT> pttts = ptttRepository.findAll();

		for (PhuongThucTT pttt : pttts) {
			int tongdonhang = thongkeService.getSoDonHangTT(pttt);
			PhuongThucTTDto ptttDto = new PhuongThucTTDto();

			ptttDto.setTen(pttt.getTen());
			ptttDto.setSoluongdon(tongdonhang);
			ptttDtos.add(ptttDto);
		}
		return ptttDtos;
	}

	@GetMapping("/ptttmonthyear")
	public List<PhuongThucTTDto> getSoLuongDonHangTheoPTTTMonthYear(@RequestParam String month,
			@RequestParam String year) {

		List<PhuongThucTTDto> ptttDtos = new ArrayList<PhuongThucTTDto>();
		List<PhuongThucTT> pttts = ptttRepository.findAll();

		int monthINT = Integer.parseInt(month);
		int yearINT = Integer.parseInt(year);
		YearMonth yearMonth = YearMonth.of(yearINT, monthINT);

		LocalDate start = LocalDate.of(yearINT, monthINT, 1);
		LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());

		for (PhuongThucTT pttt : pttts) {

			int tongdonhang = thongkeService.getSoDonHangTTwithMonthYear(pttt, start, end);

			PhuongThucTTDto ptttDto = new PhuongThucTTDto();

			ptttDto.setTen(pttt.getTen());
			ptttDto.setSoluongdon(tongdonhang);
			ptttDtos.add(ptttDto);
		}
		return ptttDtos;
	}

	@GetMapping("/ptttmonth")
	public List<PhuongThucTTDto> getSoLuongDonHangTheoPTTTMonth(@RequestParam String month) {

		List<PhuongThucTTDto> ptttDtos = new ArrayList<PhuongThucTTDto>();
		List<PhuongThucTT> pttts = ptttRepository.findAll();
		int monthINT = Integer.parseInt(month);
		for (PhuongThucTT pttt : pttts) {

			int tongdonhang = thongkeService.getSoDonHangTTwithMonth(pttt, monthINT);

			PhuongThucTTDto ptttDto = new PhuongThucTTDto();

			ptttDto.setTen(pttt.getTen());
			ptttDto.setSoluongdon(tongdonhang);
			ptttDtos.add(ptttDto);
		}
		return ptttDtos;
	}

	@GetMapping("/ptttyear")
	public List<PhuongThucTTDto> getSoLuongDonHangTheoPTTTYear(@RequestParam String year) {

		List<PhuongThucTTDto> ptttDtos = new ArrayList<PhuongThucTTDto>();
		List<PhuongThucTT> pttts = ptttRepository.findAll();
		int yearINT = Integer.parseInt(year);
		for (PhuongThucTT pttt : pttts) {

			int tongdonhang = thongkeService.getSoDonHangTTwithYear(pttt, yearINT);

			PhuongThucTTDto ptttDto = new PhuongThucTTDto();

			ptttDto.setTen(pttt.getTen());
			ptttDto.setSoluongdon(tongdonhang);
			ptttDtos.add(ptttDto);		}
		return ptttDtos;
	}

}
