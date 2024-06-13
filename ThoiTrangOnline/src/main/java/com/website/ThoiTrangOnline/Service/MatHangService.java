package com.website.ThoiTrangOnline.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;

@Service
public class MatHangService {
	
	@Autowired DonHangRepository donhangRepository;
 
	public int getTongLuotBanMH(MatHang mathang) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndTrangthaidh_id(mathang, 3);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }
			    
		return tongluotban;
	}
	public int getTongDoanhThuMH(MatHang mathang) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndTrangthaidh_id(mathang, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}		
	
	public double getSoLuongMatHangTB(MatHang mathang) {
		 List<DonHang> donhangs = donhangRepository.findByMathangAndTrangthaidh_id(mathang, 3);
		    int tongdonhang = donhangs.size();
		    if (tongdonhang == 0) {
		        return 0.0; // Trả về 0 nếu không có đơn hàng nào
		    }
		    int tongluotban = 0;
		    for (DonHang donhang : donhangs) {
		        tongluotban += donhang.getSoluong();
		    }
		    return Math.round(((double) tongluotban / tongdonhang) * 100.0) / 100.0;
		}
	
	public int getTongLuotBanwithMonthYearMH(MatHang mathang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatBetweenAndTrangthaidh_id(mathang, start, end, 3);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	public int getTongDoanhThuwithMonthYearMH(MatHang mathang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatBetweenAndTrangthaidh_id(mathang, start, end, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	public double getSoLuongMatHangTBwithMonthYear(MatHang mathang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatBetweenAndTrangthaidh_id(mathang, start, end, 3);
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		int tongluotban = 0;
		for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			    
		return Math.round(((double) tongluotban / tongdonhang) * 100.0) / 100.0;		
	}
	
	public int getTongLuotBanwithMonthMH(MatHang mathang, int month) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatMonthAndTrangthaidh_id(mathang, month, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	public int getTongDoanhThuwithMonthMH(MatHang mathang, int month) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatMonthAndTrangthaidh_id(mathang, month, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	public double getSoLuongMatHangTBwithMonth(MatHang mathang, int month) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatMonthAndTrangthaidh_id(mathang, month, 3);
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		int tongluotban = 0;
		for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			    
		return Math.round(((double) tongluotban / tongdonhang) * 100.0) / 100.0;		
	}
	
	public int getTongLuotBanwithYearMH(MatHang mathang, int year) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatYearAndTrangthaidh_id(mathang, year, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	public int getTongDoanhThuwithYearMH(MatHang mathang, int year) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatYearAndTrangthaidh_id(mathang, year, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	public double getSoLuongMatHangTBwithYear(MatHang mathang, int year) {
		List<DonHang> donhangs = donhangRepository.findByMathangAndNgaydatYearAndTrangthaidh_id(mathang, year, 3);
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		int tongluotban = 0;
		for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			    
		return Math.round(((double) tongluotban / tongdonhang) * 100.0) / 100.0;		
	}
}
