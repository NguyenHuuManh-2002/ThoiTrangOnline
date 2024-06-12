package com.website.ThoiTrangOnline.Service;

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
		tongluotban=donhangs.size();
		return tongluotban;
	}
}
