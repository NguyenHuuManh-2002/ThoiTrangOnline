package com.website.ThoiTrangOnline.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;

@Service
public class DanhMucService {
	@Autowired
	private DonHangRepository DonHangRepository;
	
	//Tổng lượt bán của các mặt hàng thuộc 1 danh mục
    public int getTongLuotBanDM(DanhMuc danhmuc) {
        List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndTrangthaidh_id(danhmuc,3);
        int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }
		
		return tongluotban;
    }
    //Tổng doanh thu của các mặt hàng thuộc 1 danh mục
    public int getTongDoanhThuDM(DanhMuc danhmuc) {
        List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndTrangthaidh_id(danhmuc,3);
        int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
    }
    //Tổng lượt bán của các mặt hàng thuộc 1 danh mục trong 1 tháng của 1 năm
    public int getTongLuotBanwithMonthYearDM(DanhMuc danhmuc, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatBetweenAndTrangthaidh_id(danhmuc, start, end, 3);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
    //Tổng doanh thu của các mặt hàng thuộc 1 danh mục trong 1 tháng của 1 năm
	public int getTongDoanhThuwithMonthYearDM(DanhMuc danhmuc, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatBetweenAndTrangthaidh_id(danhmuc, start, end, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	//Tổng lượt bán của các mặt hàng thuộc 1 danh mục trong 1 tháng của các năm
	public int getTongLuotBanwithMonthDM(DanhMuc danhmuc, int month) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatMonthAndTrangthaidh_id(danhmuc, month, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	//Tổng doanh thu của các mặt hàng thuộc 1 danh mục trong 1 tháng của các năm
	public int getTongDoanhThuwithMonthDM(DanhMuc danhmuc, int month) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatMonthAndTrangthaidh_id(danhmuc, month, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
	
	//Tổng lượt bán của các mặt hàng thuộc 1 danh mục trong 1 năm
	public int getTongLuotBanwithYearDM(DanhMuc danhmuc, int year) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatYearAndTrangthaidh_id(danhmuc, year, 3);
		System.out.println("DonHangs: " + donhangs);
		int tongluotban = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongluotban += donhang.getSoluong();
	        }			
		return tongluotban;
	}	
    	
	//Tổng doanh thu của các mặt hàng thuộc 1 danh mục trong 1 năm
	public int getTongDoanhThuwithYearDM(DanhMuc danhmuc, int year) {
		List<DonHang> donhangs = DonHangRepository.findByMathang_DanhmucAndNgaydatYearAndTrangthaidh_id(danhmuc, year, 3);
		int tongdoanhthu = 0;   
	    for (DonHang donhang : donhangs) {	       
	    	tongdoanhthu += (donhang.getSoluong() * donhang.getMathang().getGia());
	        }		
		return tongdoanhthu;
	}
}
