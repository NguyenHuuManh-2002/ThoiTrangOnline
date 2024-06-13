package com.website.ThoiTrangOnline.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;

@Service
public class ThuongHieuService {

	@Autowired
	private DonHangRepository DonHangRepository;

	// Tổng lượt bán của các mặt hàng thuộc 1 thương hiệu
	public int getTongLuotBanTH(ThuongHieu thuonghieu) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndTrangthaidh_id(thuonghieu, 3);
		int tongluotban = 0;
		for (DonHang donhang : donhangs) {
			tongluotban += donhang.getSoluong();
		}

		return tongluotban;
	}
	//Tổng doanh thu của các mặt hàng thuộc 1 thương hiệu
	public int getTongDoanhThuTH(ThuongHieu thuonghieu) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndTrangthaidh_id(thuonghieu, 3);
		int tongdoanhthu = 0;
		for (DonHang donhang : donhangs) {
			tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongdoanhthu;
	}
	
	//Tổng lượt bán của các mặt hàng thuộc 1 thương hiệu trong 1 tháng của 1 năm
    public int getTongLuotBanwithMonthYearTH(ThuongHieu thuonghieu, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatBetweenAndTrangthaidh_id(thuonghieu, start, end, 3);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
    //Tổng doanh thu của các mặt hàng thuộc 1 thương hiệu trong 1 tháng của 1 năm
	public int getTongDoanhThuwithMonthYearTH(ThuongHieu thuonghieu, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatBetweenAndTrangthaidh_id(thuonghieu, start, end, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	//Tổng lượt bán của các mặt hàng thuộc 1 thương hiệu trong 1 tháng của các năm
	public int getTongLuotBanwithMonthTH(ThuongHieu thuonghieu, int month) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatMonthAndTrangthaidh_id(thuonghieu, month, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	//Tổng doanh thu của các mặt hàng thuộc 1 thương hiệu trong 1 tháng của các năm
	public int getTongDoanhThuwithMonthTH(ThuongHieu thuonghieu, int month) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatMonthAndTrangthaidh_id(thuonghieu, month, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	//Tổng lượt bán của các mặt hàng thuộc 1 thương hiệu trong 1 năm
	public int getTongLuotBanwithYearTH(ThuongHieu thuonghieu, int year) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatYearAndTrangthaidh_id(thuonghieu, year, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	//Tổng doanh thu của các mặt hàng thuộc 1 thương hiệu trong 1 năm
	public int getTongDoanhThuwithYearTH(ThuongHieu thuonghieu, int year) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_ThuonghieuAndNgaydatYearAndTrangthaidh_id(thuonghieu, year, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
}
