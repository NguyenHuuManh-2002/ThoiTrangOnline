package com.website.ThoiTrangOnline.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;

@Service
public class KhachHangService {
	
	@Autowired 
	private DonHangRepository DonHangRepository;
	
	//THỐNG KÊ KHÁCH HÀNG TỪ TRƯỚC ĐẾN NAY
	public int getTongDonHangKH(KhachHang khachhang) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndTrangthaidh_id(khachhang, 3);
		return donhangs.size();
	}
	
	public int getTongMatHangKH(KhachHang khachhang) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndTrangthaidh_id(khachhang, 3);
		int tongmathang=0;
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return tongmathang;
	}
	
	public int getTongChiTieuKH(KhachHang khachhang) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndTrangthaidh_id(khachhang, 3);
		int tongchitieu=0;
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu;
	}
	
	public double getMatHangtbKH(KhachHang khachhang) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndTrangthaidh_id(khachhang, 3);
		int tongmathang=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return Math.round(((double) tongmathang / tongdonhang) * 100.0) / 100.0;
	}
	
	public int getGiaTriDontbKH(KhachHang khachhang) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndTrangthaidh_id(khachhang, 3);
		int tongchitieu=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu / tongdonhang;
	}
	
	
	
	//THỐNG KÊ KHÁCH HÀNG TRONG ! THÁNG
	public int getTongDonHangwithMonthYearKH(KhachHang khachhang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(khachhang, start, end, 3);
		return donhangs.size();
	}
	
	public int getTongMatHangwithMonthYearKH(KhachHang khachhang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(khachhang, start, end, 3);
		int tongmathang=0;
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return tongmathang;
	}
	
	public int getTongChiTieuwithMonthYearKH(KhachHang khachhang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(khachhang, start, end, 3);
		int tongchitieu=0;
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu;
	}
	
	public double getMatHangtbwithMonthYearKH(KhachHang khachhang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(khachhang, start, end, 3);
		int tongmathang=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return Math.round(((double) tongmathang / tongdonhang) * 100.0) / 100.0;
	}
	
	public int getGiaTriDontbwithMonthYearKH(KhachHang khachhang, LocalDate start, LocalDate end) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(khachhang, start, end, 3);
		int tongchitieu=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu / tongdonhang;
	}
	
	
	//THỐNG KÊ KHÁCH HÀNG THEO ! THÁNG TRONG CÁC NĂM
	public int getTongDonHangwithMonthKH(KhachHang khachhang, int month) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatMonthAndTrangthaidh_id(khachhang, month, 3);
		return donhangs.size();
	}
	
	public int getTongMatHangwithMonthKH(KhachHang khachhang, int month) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatMonthAndTrangthaidh_id(khachhang, month, 3);
		int tongmathang=0;
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return tongmathang;
	}
	
	public int getTongChiTieuwithMonthKH(KhachHang khachhang, int month) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatMonthAndTrangthaidh_id(khachhang, month, 3);
		int tongchitieu=0;
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu;
	}
	
	public double getMatHangtbwithMonthKH(KhachHang khachhang, int month) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatMonthAndTrangthaidh_id(khachhang, month, 3);
		int tongmathang=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return Math.round(((double) tongmathang / tongdonhang) * 100.0) / 100.0;
	}
	
	public int getGiaTriDontbwithMonthKH(KhachHang khachhang, int month) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatMonthAndTrangthaidh_id(khachhang, month, 3);
		int tongchitieu=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu / tongdonhang;
	}
	
	//THỐNG KÊ KHÁCH HÀNG THEO NĂM
	public int getTongDonHangwithYearKH(KhachHang khachhang, int year) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatYearAndTrangthaidh_id(khachhang, year, 3);
		return donhangs.size();
	}
	
	public int getTongMatHangwithYearKH(KhachHang khachhang, int year) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatYearAndTrangthaidh_id(khachhang, year, 3);
		int tongmathang=0;
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return tongmathang;
	}
	
	public int getTongChiTieuwithYearKH(KhachHang khachhang, int year) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatYearAndTrangthaidh_id(khachhang, year, 3);
		int tongchitieu=0;
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu;
	}
	
	public double getMatHangtbwithYearKH(KhachHang khachhang, int year) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatYearAndTrangthaidh_id(khachhang, year, 3);
		int tongmathang=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0.0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return Math.round(((double) tongmathang / tongdonhang) * 100.0) / 100.0;
	}
	
	public int getGiaTriDontbwithYearKH(KhachHang khachhang, int year) {
		List<DonHang> donhangs = DonHangRepository.findByKhachhangAndNgaydatYearAndTrangthaidh_id(khachhang, year, 3);
		int tongchitieu=0;
		int tongdonhang = donhangs.size();
		if (tongdonhang == 0) {
	        return 0; // Trả về 0 nếu không có đơn hàng nào
	    }
		for(DonHang donhang : donhangs) {
			tongchitieu += (donhang.getSoluong() * donhang.getMathang().getGia());
		}
		return tongchitieu / tongdonhang;
	}
}
