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

import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.ModelDto.MatHangDto;
import com.website.ThoiTrangOnline.Repository.MatHangRepository;
import com.website.ThoiTrangOnline.Service.MatHangService;



@RestController
public class MatHangTKController {

	@Autowired
    private MatHangService mathangService;
	
    @Autowired
    private MatHangRepository mathangRepository;

    @GetMapping("/mathang")
    public List<MatHangDto> getAllMatHang() {
    	
        List<MatHang> mathangs = mathangRepository.findAll();
        if (mathangs == null || mathangs.isEmpty()) {
            return (List<MatHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Mathang found");
        }

        List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();

        for (MatHang mathang : mathangs) {
            int tongsoluong = mathangService.getTongLuotBanMH(mathang);
            int tongdoanhthu = mathangService.getTongDoanhThuMH(mathang);
            double soluongtb = mathangService.getSoLuongMatHangTB(mathang);

            MatHangDto mathangDto = new MatHangDto();
            mathangDto.setId(mathang.getId());
            mathangDto.setTen(mathang.getTen());
            mathangDto.setSoluongtb(soluongtb);
            mathangDto.setTongsoluong(tongsoluong);
            mathangDto.setTongdoanhthu(tongdoanhthu);
            mathangDtos.add(mathangDto);
        }
        return mathangDtos;
    }
    @GetMapping("/mathangmonthyear")
    public List<MatHangDto> getAllMatHangwithMonthYear(@RequestParam String month, @RequestParam String year){   	
    	List<MatHang> mathangs = mathangRepository.findAll(); 
    	
    	if (mathangs == null || mathangs.isEmpty()) {
            return (List<MatHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int monthINT = Integer.parseInt(month);
    	int yearINT = Integer.parseInt(year);
    	YearMonth yearMonth = YearMonth.of(yearINT, monthINT);
    	
    	LocalDate start = LocalDate.of(yearINT, monthINT, 1);
    	LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());
    	
    	List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
    	
    	for (MatHang mathang : mathangs) {
            int tongsoluong = mathangService.getTongLuotBanwithMonthYearMH(mathang, start, end);
            int tongdoanhthu = mathangService.getTongDoanhThuwithMonthYearMH(mathang, start, end);
            double soluongtb = mathangService.getSoLuongMatHangTBwithMonthYear(mathang, start, end);

            MatHangDto mathangDto = new MatHangDto();
            mathangDto.setId(mathang.getId());
            mathangDto.setTen(mathang.getTen());
            mathangDto.setSoluongtb(soluongtb);
            mathangDto.setTongsoluong(tongsoluong);
            mathangDto.setTongdoanhthu(tongdoanhthu);
            mathangDtos.add(mathangDto);
        }
    	return mathangDtos;
    }
    @GetMapping("/mathangmonth")
    public List<MatHangDto> getAllMatHangwithMonth(@RequestParam String month){   	
    	List<MatHang> mathangs = mathangRepository.findAll(); 
    	
    	if (mathangs == null || mathangs.isEmpty()) {
            return (List<MatHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int monthINT = Integer.parseInt(month);
    	
    	List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
    	
    	for (MatHang mathang : mathangs) {
            int tongsoluong = mathangService.getTongLuotBanwithMonthMH(mathang, monthINT);
            int tongdoanhthu = mathangService.getTongDoanhThuwithMonthMH(mathang, monthINT);
            double soluongtb = mathangService.getSoLuongMatHangTBwithMonth(mathang, monthINT);

            MatHangDto mathangDto = new MatHangDto();
            mathangDto.setId(mathang.getId());
            mathangDto.setTen(mathang.getTen());
            mathangDto.setSoluongtb(soluongtb);
            mathangDto.setTongsoluong(tongsoluong);
            mathangDto.setTongdoanhthu(tongdoanhthu);
            mathangDtos.add(mathangDto);
        }
    	return mathangDtos;
    }
    @GetMapping("/mathangyear")
    public List<MatHangDto> getAllMatHangwithYear(@RequestParam String year){   	
    	List<MatHang> mathangs = mathangRepository.findAll(); 
    	
    	if (mathangs == null || mathangs.isEmpty()) {
            return (List<MatHangDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int yearINT = Integer.parseInt(year);
    	
    	List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();
    	
    	for (MatHang mathang : mathangs) {
            int tongsoluong = mathangService.getTongLuotBanwithYearMH(mathang, yearINT);
            int tongdoanhthu = mathangService.getTongDoanhThuwithYearMH(mathang, yearINT);
            double soluongtb = mathangService.getSoLuongMatHangTBwithYear(mathang, yearINT);
            
            MatHangDto mathangDto = new MatHangDto();
            mathangDto.setId(mathang.getId());
            mathangDto.setTen(mathang.getTen());
            mathangDto.setSoluongtb(soluongtb);
            mathangDto.setTongsoluong(tongsoluong);
            mathangDto.setTongdoanhthu(tongdoanhthu);
            mathangDtos.add(mathangDto);
        }
    	return mathangDtos;
    }
}
