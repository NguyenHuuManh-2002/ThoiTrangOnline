package com.website.ThoiTrangOnline.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.ModelDto.ThuongHieuDto;
import com.website.ThoiTrangOnline.Repository.ThuongHieuRepository;
import com.website.ThoiTrangOnline.Service.ThuongHieuService;

@RestController
public class ThuongHieuTKController {
	@Autowired
    private ThuongHieuService thuonghieuService;
    
    @Autowired
    private ThuongHieuRepository thuonghieuRepository;
    
    @GetMapping("/thuonghieutk")
    public List<ThuongHieuDto> getAllThuonghieu() {
    	
    	
        List<ThuongHieu> thuonghieus = thuonghieuRepository.findAll();
        if (thuonghieus == null || thuonghieus.isEmpty()) {
            return (List<ThuongHieuDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No categories found");
        }

        List<ThuongHieuDto> thuonghieuDtos = new ArrayList<ThuongHieuDto>();

        for (ThuongHieu thuonghieu : thuonghieus) {
        	
            int tongsoluong = thuonghieuService.getTongLuotBanTH(thuonghieu);
            int tongdoanhthu = thuonghieuService.getTongDoanhThuTH(thuonghieu);

            ThuongHieuDto thuonghieuDto = new ThuongHieuDto();
            thuonghieuDto.setId(thuonghieu.getId());
            thuonghieuDto.setTen(thuonghieu.getTen());
            thuonghieuDto.setTongsoluong(tongsoluong);
            thuonghieuDto.setTongdoanhthu(tongdoanhthu);
            thuonghieuDtos.add(thuonghieuDto);
        }
        return thuonghieuDtos;
    }
    
    
    @GetMapping("/thuonghieumonthyear")
    public List<ThuongHieuDto> getAllThuongHieuwithMonthYear(@RequestParam String month, @RequestParam String year){   	
    	List<ThuongHieu> thuonghieus = thuonghieuRepository.findAll(); 
    	
    	if (thuonghieus == null || thuonghieus.isEmpty()) {
            return (List<ThuongHieuDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int monthINT = Integer.parseInt(month);
    	int yearINT = Integer.parseInt(year);
    	YearMonth yearMonth = YearMonth.of(yearINT, monthINT);
    	
    	LocalDate start = LocalDate.of(yearINT, monthINT, 1);
    	LocalDate end = LocalDate.of(yearINT, monthINT, yearMonth.lengthOfMonth());
    	
    	List<ThuongHieuDto> thuonghieuDtos = new ArrayList<ThuongHieuDto>();
    	
    	for (ThuongHieu thuonghieu : thuonghieus) {
            int tongsoluong = thuonghieuService.getTongLuotBanwithMonthYearTH(thuonghieu, start, end);
            int tongdoanhthu = thuonghieuService.getTongDoanhThuwithMonthYearTH(thuonghieu, start, end);

            ThuongHieuDto thuonghieuDto = new ThuongHieuDto();
            thuonghieuDto.setId(thuonghieu.getId());
            thuonghieuDto.setTen(thuonghieu.getTen());
            thuonghieuDto.setTongsoluong(tongsoluong);
            thuonghieuDto.setTongdoanhthu(tongdoanhthu);
            thuonghieuDtos.add(thuonghieuDto);
        }
    	return thuonghieuDtos;
    }
    @GetMapping("/thuonghieumonth")
    public List<ThuongHieuDto> getAllTuongHieuwithMonth(@RequestParam String month){   	
    	List<ThuongHieu> thuonghieus = thuonghieuRepository.findAll(); 
    	
    	if (thuonghieus == null || thuonghieus.isEmpty()) {
            return (List<ThuongHieuDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int monthINT = Integer.parseInt(month);
    	Month monthM = Month.of(monthINT);
    	
    	List<ThuongHieuDto> thuonghieuDtos = new ArrayList<ThuongHieuDto>();
    	
    	for (ThuongHieu thuonghieu : thuonghieus) {
            int tongsoluong = thuonghieuService.getTongLuotBanwithMonthTH(thuonghieu, monthINT);
            int tongdoanhthu = thuonghieuService.getTongDoanhThuwithMonthTH(thuonghieu, monthINT);

            ThuongHieuDto thuonghieuDto = new ThuongHieuDto();
            thuonghieuDto.setId(thuonghieu.getId());
            thuonghieuDto.setTen(thuonghieu.getTen());
            thuonghieuDto.setTongsoluong(tongsoluong);
            thuonghieuDto.setTongdoanhthu(tongdoanhthu);
            thuonghieuDtos.add(thuonghieuDto);
        }
    	return thuonghieuDtos;
    }
    @GetMapping("/thuonghieuyear")
    public List<ThuongHieuDto> getAllThuongHieuwithYear(@RequestParam String year){   	
    	List<ThuongHieu> thuonghieus = thuonghieuRepository.findAll(); 
    	
    	if (thuonghieus == null || thuonghieus.isEmpty()) {
            return (List<ThuongHieuDto>) ResponseEntity.status(HttpStatus.NO_CONTENT).body("No MatHang found");
        }
    	
    	int yearINT = Integer.parseInt(year);
    	Year yearY = Year.of(yearINT);

    	
    	List<ThuongHieuDto> thuonghieuDtos = new ArrayList<ThuongHieuDto>();
    	
    	for (ThuongHieu thuonghieu : thuonghieus) {
            int tongsoluong = thuonghieuService.getTongLuotBanwithYearTH(thuonghieu, yearINT);
            int tongdoanhthu = thuonghieuService.getTongDoanhThuwithYearTH(thuonghieu, yearINT);

            ThuongHieuDto danhmucDto = new ThuongHieuDto();
            danhmucDto.setId(thuonghieu.getId());
            danhmucDto.setTen(thuonghieu.getTen());
            danhmucDto.setTongsoluong(tongsoluong);
            danhmucDto.setTongdoanhthu(tongdoanhthu);
            thuonghieuDtos.add(danhmucDto);
        }
    	return thuonghieuDtos;
    }
}
