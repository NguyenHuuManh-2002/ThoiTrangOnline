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

import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.ModelDto.KhachHangDto;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Service.KhachHangService;

@RestController
public class KhachHangTKController {

	
	@Autowired
	private KhachHangService khachhangService;
	
	@Autowired
	private KhachHangRepository khachhangRepository;
	
	 @GetMapping("/khachhang")
	    public List<KhachHangDto> getAllKhachHang() {
	    	
	        List<KhachHang> khachhangs = khachhangRepository.findAll();
	        
	        if (khachhangs == null || khachhangs.isEmpty()) {
	            return (List<KhachHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Khachhang found");
	        }

	        List<KhachHangDto> khachhangDtos = new ArrayList<KhachHangDto>();

	        for (KhachHang khachhang : khachhangs) {
	        	
	            int tongdonhang =khachhangService.getTongDonHangKH(khachhang);
	            int tongmathang = khachhangService.getTongMatHangKH(khachhang);
	            int tongchitieu = khachhangService.getTongChiTieuKH(khachhang);
	            double mathangtb = khachhangService.getMatHangtbKH(khachhang);
	            int giatridontb = khachhangService.getGiaTriDontbKH(khachhang);

	            KhachHangDto khachhangDto = new KhachHangDto();
	            
	            khachhangDto.setId(khachhang.getId());
	            khachhangDto.setTen(khachhang.getTen());
	            khachhangDto.setTongdonhang(tongdonhang);
	            khachhangDto.setTongmathang(tongmathang);
	            khachhangDto.setTongchitieu(tongchitieu);
	            khachhangDto.setSomathangtb(mathangtb);
	            khachhangDto.setGiatridontb(giatridontb);
	            
	            khachhangDtos.add(khachhangDto);
	        }
	        return khachhangDtos;
	    }
	 
	 
	 @GetMapping("/khachhangmonthyear")
	    public List<KhachHangDto> getAllKhachHangwithMonthYear(@RequestParam String month, @RequestParam String year) {
	    	
	        List<KhachHang> khachhangs = khachhangRepository.findAll();
	        
	        if (khachhangs == null || khachhangs.isEmpty()) {
	            return (List<KhachHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Mathang found");
	        }

	        int monthINT = Integer.parseInt(month);
	    	int yearINT = Integer.parseInt(year);
	    	YearMonth yearMonth = YearMonth.of(yearINT, monthINT);
	    	
	    	LocalDate start = LocalDate.of(yearINT, monthINT, 1);
	    	LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());

	    	
	        List<KhachHangDto> khachhangDtos = new ArrayList<KhachHangDto>();

	        for (KhachHang khachhang : khachhangs) {
	        	
	            int tongdonhang =khachhangService.getTongDonHangwithMonthYearKH(khachhang, start, end);
	            int tongmathang = khachhangService.getTongMatHangwithMonthYearKH(khachhang, start, end);
	            int tongchitieu = khachhangService.getTongChiTieuwithMonthYearKH(khachhang, start, end);
	            double mathangtb = khachhangService.getMatHangtbwithMonthYearKH(khachhang, start, end);
	            int giatridontb = khachhangService.getGiaTriDontbwithMonthYearKH(khachhang, start, end);

	            KhachHangDto khachhangDto = new KhachHangDto();
	            
	            khachhangDto.setId(khachhang.getId());
	            khachhangDto.setTen(khachhang.getTen());
	            khachhangDto.setTongdonhang(tongdonhang);
	            khachhangDto.setTongmathang(tongmathang);
	            khachhangDto.setTongchitieu(tongchitieu);
	            khachhangDto.setSomathangtb(mathangtb);
	            khachhangDto.setGiatridontb(giatridontb);
	            
	            khachhangDtos.add(khachhangDto);
	        }
	        return khachhangDtos;
	    }
	 
	 
	 @GetMapping("/khachhangmonth")
	    public List<KhachHangDto> getAllKhachHangwithMonth(@RequestParam String month) {
	    	
	        List<KhachHang> khachhangs = khachhangRepository.findAll();
	        
	        if (khachhangs == null || khachhangs.isEmpty()) {
	            return (List<KhachHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Mathang found");
	        }

	        int monthINT = Integer.parseInt(month);

	    	
	        List<KhachHangDto> khachhangDtos = new ArrayList<KhachHangDto>();

	        for (KhachHang khachhang : khachhangs) {
	        	
	            int tongdonhang =khachhangService.getTongDonHangwithMonthKH(khachhang, monthINT);
	            int tongmathang = khachhangService.getTongMatHangwithMonthKH(khachhang, monthINT);
	            int tongchitieu = khachhangService.getTongChiTieuwithMonthKH(khachhang, monthINT);
	            double mathangtb = khachhangService.getMatHangtbwithMonthKH(khachhang, monthINT);
	            int giatridontb = khachhangService.getGiaTriDontbwithMonthKH(khachhang, monthINT);

	            KhachHangDto khachhangDto = new KhachHangDto();
	            
	            khachhangDto.setId(khachhang.getId());
	            khachhangDto.setTen(khachhang.getTen());
	            khachhangDto.setTongdonhang(tongdonhang);
	            khachhangDto.setTongmathang(tongmathang);
	            khachhangDto.setTongchitieu(tongchitieu);
	            khachhangDto.setSomathangtb(mathangtb);
	            khachhangDto.setGiatridontb(giatridontb);
	            
	            khachhangDtos.add(khachhangDto);
	        }
	        return khachhangDtos;
	    }
	 
	 
	 
	 @GetMapping("/khachhangyear")
	    public List<KhachHangDto> getAllKhachHangwithYear(@RequestParam String year) {
	    	
	        List<KhachHang> khachhangs = khachhangRepository.findAll();
	        
	        if (khachhangs == null || khachhangs.isEmpty()) {
	            return (List<KhachHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Mathang found");
	        }

	        int yearINT = Integer.parseInt(year);

	    	
	        List<KhachHangDto> khachhangDtos = new ArrayList<KhachHangDto>();

	        for (KhachHang khachhang : khachhangs) {
	        	
	            int tongdonhang =khachhangService.getTongDonHangwithYearKH(khachhang, yearINT);
	            int tongmathang = khachhangService.getTongMatHangwithYearKH(khachhang, yearINT);
	            int tongchitieu = khachhangService.getTongChiTieuwithYearKH(khachhang, yearINT);
	            double mathangtb = khachhangService.getMatHangtbwithYearKH(khachhang, yearINT);
	            int giatridontb = khachhangService.getGiaTriDontbwithYearKH(khachhang, yearINT);

	            KhachHangDto khachhangDto = new KhachHangDto();
	            
	            khachhangDto.setId(khachhang.getId());
	            khachhangDto.setTen(khachhang.getTen());
	            khachhangDto.setTongdonhang(tongdonhang);
	            khachhangDto.setTongmathang(tongmathang);
	            khachhangDto.setTongchitieu(tongchitieu);
	            khachhangDto.setSomathangtb(mathangtb);
	            khachhangDto.setGiatridontb(giatridontb);
	            
	            khachhangDtos.add(khachhangDto);
	        }
	        return khachhangDtos;
	    }
}
