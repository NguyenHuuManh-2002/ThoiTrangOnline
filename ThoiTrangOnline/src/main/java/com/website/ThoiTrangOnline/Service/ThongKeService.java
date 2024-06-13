package com.website.ThoiTrangOnline.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.PhuongThucTT;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;

@Service
public class ThongKeService {

	@Autowired
	private DonHangRepository DonHangRepository;

	public int getTongDoanhThuMonth(LocalDate start, LocalDate end) {

		List<DonHang> donhangs = DonHangRepository.findByNgaydatBetweenAndTrangthaidh_id(start, end, 3);
		int tongdoanhthu = 0;
		for (DonHang donhang : donhangs) {
			tongdoanhthu += (donhang.getMathang().getGia() * donhang.getSoluong());
		}
		return tongdoanhthu;
	}

	public int getTongDonHangMonth(LocalDate start, LocalDate end) {

		List<DonHang> donhangs = DonHangRepository.findByNgaydatBetweenAndTrangthaidh_id(start, end, 3);

		return donhangs.size();
	}

	public int getTongMatHangMonth(LocalDate start, LocalDate end) {

		List<DonHang> donhangs = DonHangRepository.findByNgaydatBetweenAndTrangthaidh_id(start, end, 3);
		int tongmathang = 0;
		for (DonHang donhang : donhangs) {
			tongmathang += donhang.getSoluong();
		}
		return tongmathang;
	}
	
	public int getSoDonHangNhoHon(int amount) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienLessThanAndTrangthaidh_id(amount, 3);
		return donhangs.size();
	}
	public int getSoDonHangTrongKhoang(int minAmount, int maxAmount) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienBetweenAndTrangthaidh_id(minAmount, maxAmount, 3);
		return donhangs.size();
	}
	public int getSoDonHangLonHon(int amount) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienGreaterThanAndTrangthaidh_id(amount, 3);
		return donhangs.size();
	}
	
	public int getSoDonHangNhoHonwithMonthYear(int amount, LocalDate start, LocalDate end) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienLessThanAndNgaydatBetweenAndTrangthaidh_id(amount, start, end, 3);
		return donhangs.size();
	}
	public int getSoDonHangTrongKhoangwithMonthYear(int minAmount, int maxAmount, LocalDate start, LocalDate end) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienBetweenAndNgaydatBetweenAndTrangthaidh_id(minAmount, maxAmount, start, end, 3);
		return donhangs.size();
	}
	public int getSoDonHangLonHonwithMonthYear(int amount, LocalDate start, LocalDate end) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienGreaterThanAndNgaydatBetweenAndTrangthaidh_id(amount, start, end, 3);
		return donhangs.size();
	}
	
	
	public int getSoDonHangNhoHonwithMonth(int amount, int month) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienLessThanAndNgaydatMonthAndTrangthaidh_id(amount, month, 3);
		return donhangs.size();
	}
	public int getSoDonHangTrongKhoangwithMonth(int minAmount, int maxAmount, int month) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienBetweenAndNgaydatMonthAndTrangthaidh_id(minAmount, maxAmount, month, 3);
		return donhangs.size();
	}
	public int getSoDonHangLonHonwithMonth(int amount, int month) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienGreaterThanAndNgaydatMonthAndTrangthaidh_id(amount, month, 3);
		return donhangs.size();
	}
	
	
	public int getSoDonHangNhoHonwithYear(int amount, int year) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienLessThanAndNgaydatYearAndTrangthaidh_id(amount, year, 3);
		return donhangs.size();
	}
	public int getSoDonHangTrongKhoangwithYear(int minAmount, int maxAmount, int year) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienBetweenAndNgaydatYearAndTrangthaidh_id(minAmount, maxAmount, year, 3);
		return donhangs.size();
	}
	public int getSoDonHangLonHonwithYear(int amount, int year) {		
		List<DonHang> donhangs = DonHangRepository.findByTongtienGreaterThanAndNgaydatYearAndTrangthaidh_id(amount, year, 3);
		return donhangs.size();
	}
	
	public int getSoDonHangTT(PhuongThucTT phuongthucTT) {		
		List<DonHang> donhangs = DonHangRepository.findByPhuongthucttAndTrangthaidh_id(phuongthucTT, 3);
		return donhangs.size();
	}
	
	public int getSoDonHangTTwithMonthYear(PhuongThucTT phuongthucTT, LocalDate start, LocalDate end) {		
		List<DonHang> donhangs = DonHangRepository.findByPhuongthucttAndNgaydatBetweenAndTrangthaidh_id(phuongthucTT, start, end, 3);
		return donhangs.size();
	}
	
	public int getSoDonHangTTwithMonth(PhuongThucTT phuongthucTT, int month) {		
		List<DonHang> donhangs = DonHangRepository.findByPhuongthucttAndNgaydatMonthAndTrangthaidh_id(phuongthucTT, month, 3);
		return donhangs.size();
	}
	
	public int getSoDonHangTTwithYear(PhuongThucTT phuongthucTT, int year) {		
		List<DonHang> donhangs = DonHangRepository.findByPhuongthucttAndNgaydatYearAndTrangthaidh_id(phuongthucTT, year, 3);
		return donhangs.size();
	}
	
}
