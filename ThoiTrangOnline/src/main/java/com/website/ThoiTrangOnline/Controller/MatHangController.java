package com.website.ThoiTrangOnline.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.Model.PhuongThucTT;
import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.Model.TrangThaiDH;
import com.website.ThoiTrangOnline.ModelDto.DonHangDto;
import com.website.ThoiTrangOnline.ModelDto.MatHangDto;
import com.website.ThoiTrangOnline.Repository.DanhMucRepository;
import com.website.ThoiTrangOnline.Repository.DonHangRepository;
import com.website.ThoiTrangOnline.Repository.KhachHangRepository;
import com.website.ThoiTrangOnline.Repository.MatHangRepository;
import com.website.ThoiTrangOnline.Repository.PhuongThucTTRepository;
import com.website.ThoiTrangOnline.Repository.ThuongHieuRepository;
import com.website.ThoiTrangOnline.Repository.TrangThaiDHRepository;
import com.website.ThoiTrangOnline.Service.MatHangService;

@Controller
public class MatHangController {

	@Autowired
	MatHangRepository mathangRepository;
	@Autowired
	MatHangService mathangService;
	@Autowired
	KhachHangRepository khachhangRepository;
	@Autowired
	PhuongThucTTRepository phuongthucttRepository;
	@Autowired
	TrangThaiDHRepository trangthaidhRepository;
	@Autowired
	DonHangRepository donhangRepository;
	@Autowired
	DanhMucRepository danhmucRepository;
	@Autowired
	ThuongHieuRepository thuonghieuRepository;
	
	@GetMapping("/chitietmathang")
	public String showChiTietMatHang(@RequestParam String mathang_id, @RequestParam String khachhang_id,  Model model) {

		MatHangDto chitietmathang = new MatHangDto();
		

		int mathang_id_int = Integer.parseInt(mathang_id);
		Optional<MatHang> mathangfind = mathangRepository.findById(mathang_id_int);
		MatHang mathang = mathangfind.get();

		chitietmathang.setId(mathang.getId());
		chitietmathang.setConlai(mathang.getSoluong());
		chitietmathang.setTen(mathang.getTen());
		chitietmathang.setDanhmuc(mathang.getDanhmuc().getTen());
		chitietmathang.setThuonghieu(mathang.getThuonghieu().getTen());
		chitietmathang.setGia(mathang.getGia());
		chitietmathang.setImgmathang(mathang.getImgmathang());
		chitietmathang.setLuotban(mathangService.getTongLuotBanMH(mathang));
		
		
		
		List<MatHang> mathanglienquans = new ArrayList<MatHang>();
		mathanglienquans = mathangRepository.findAllByDanhmuc(mathang.getDanhmuc());
		mathanglienquans.remove(mathang);
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();

		for (MatHang mathanglienquan : mathanglienquans) {
			
			MatHangDto matHangDto = new MatHangDto();

			matHangDto.setId(mathanglienquan.getId());
			matHangDto.setTen(mathanglienquan.getTen());
			matHangDto.setGia(mathanglienquan.getGia());
			matHangDto.setImgmathang(mathanglienquan.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathanglienquan));

			mathangDtos.add(matHangDto);
		}
		
		Collections.sort(mathangDtos, (o1, o2) -> o2.getLuotban() - o1.getLuotban());
		
		List<MatHangDto> topmathanglienquan = new ArrayList<>(mathangDtos.subList(0, Math.min(mathangDtos.size(), 12)));
		
		model.addAttribute("chitietmathang", chitietmathang);
		model.addAttribute("lienquans", topmathanglienquan);
		model.addAttribute("khachhang_id", khachhang_id);
		
		return "khachhang/chitietmathang";
	}
	@GetMapping("/muahang")
	public String showMuaHang(@RequestParam String mathang_id, @RequestParam String khachhang_id, Model model) {
		
		DonHangDto donhangDto = new DonHangDto();
		
		int mathang_id_int = Integer.parseInt(mathang_id);
		int khachhang_id_int = Integer.parseInt(khachhang_id);
		
		Optional<MatHang> mathangfind = mathangRepository.findById(mathang_id_int);
		Optional<KhachHang> khachhangfind = khachhangRepository.findById(khachhang_id_int);
		
		MatHang mathang = mathangfind.get();
		KhachHang khachhang = khachhangfind.get();
		
		donhangDto.setId_khachhang(khachhang_id_int);
		donhangDto.setId_mathang(mathang_id_int);
		donhangDto.setImgmathang(mathang.getImgmathang());
		donhangDto.setGia(mathang.getGia());
		donhangDto.setTen(mathang.getTen());
		donhangDto.setConlai(mathang.getSoluong());
		donhangDto.setSoluong(1);
		donhangDto.setPhuongthuctt(1);
		
		model.addAttribute("donhangMuaDto", donhangDto);
		return "khachhang/muahangview";
	}
	@PostMapping("/muahang")
	public String SaveDonHang(@ModelAttribute DonHangDto donhangMuaDto) {
		
		DonHang donhang = new DonHang();
		Optional<KhachHang> khachhang = khachhangRepository.findById(donhangMuaDto.getId_khachhang());
		Optional<MatHang> mathang = mathangRepository.findById(donhangMuaDto.getId_mathang());
		Optional<PhuongThucTT> phuongthuctt = phuongthucttRepository.findById(donhangMuaDto.getPhuongthuctt());
		Optional<TrangThaiDH> trangthaidh = trangthaidhRepository.findById(1);
		
		donhang.setSoluong(donhangMuaDto.getSoluong());
		donhang.setTongtien(mathang.get().getGia() * donhangMuaDto.getSoluong());
		donhang.setNgaydat(LocalDate.now());
		donhang.setKhachhang(khachhang.get());
		donhang.setMathang(mathang.get());
		donhang.setPhuongthuctt(phuongthuctt.get());
		donhang.setTrangthaidh(trangthaidh.get());
		
		donhangRepository.save(donhang);
		
		MatHang mathangupdate = mathang.get();
		mathangupdate.setSoluong(mathangupdate.getSoluong() - donhangMuaDto.getSoluong());
		mathangRepository.save(mathangupdate);
		return "redirect:/home?khachhang_id=" + donhangMuaDto.getId_khachhang();
	}
	
	@GetMapping("/allmathangdanhmuc")
	public String showAllMatHangthuocDanhMuc(@RequestParam String khachhang_id, @RequestParam String danhmuc_id, Model model) {
		
		List<MatHang> mathangs =mathangRepository.findByDanhmuc_id(Integer.parseInt(danhmuc_id));
		
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();

		for (MatHang mathang : mathangs) {
			
			MatHangDto matHangDto = new MatHangDto();

			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));

			mathangDtos.add(matHangDto);
		}
		
		Collections.sort(mathangDtos, (o1, o2) -> o2.getLuotban() - o1.getLuotban());
		Optional<DanhMuc> danhmucfind = danhmucRepository.findById(Integer.parseInt(danhmuc_id));
		DanhMuc danhmuc = danhmucfind.get();
		
		model.addAttribute("tendanhmuc", danhmuc.getTen());
		model.addAttribute("mathangs", mathangDtos);
		model.addAttribute("khachhang_id", khachhang_id);
		return "khachhang/allmathang_dm";
	}
	
	
	@GetMapping("/allmathangthuonghieu")
	public String showAllMatHangthuocThuongHieu(@RequestParam String khachhang_id, @RequestParam String thuonghieu_id, Model model) {
		
		List<MatHang> mathangs =mathangRepository.findByThuonghieu_id(Integer.parseInt(thuonghieu_id));
		
		List<MatHangDto> mathangDtos = new ArrayList<MatHangDto>();

		for (MatHang mathang : mathangs) {
			
			MatHangDto matHangDto = new MatHangDto();

			matHangDto.setId(mathang.getId());
			matHangDto.setTen(mathang.getTen());
			matHangDto.setGia(mathang.getGia());
			matHangDto.setImgmathang(mathang.getImgmathang());
			matHangDto.setLuotban(mathangService.getTongLuotBanMH(mathang));

			mathangDtos.add(matHangDto);
		}
		
		Collections.sort(mathangDtos, (o1, o2) -> o2.getLuotban() - o1.getLuotban());
		Optional<ThuongHieu> thuonghieufind = thuonghieuRepository.findById(Integer.parseInt(thuonghieu_id));
		ThuongHieu thuonghieu = thuonghieufind.get();
		
		model.addAttribute("tenthuonghieu", thuonghieu.getTen());
		model.addAttribute("mathangs", mathangDtos);
		model.addAttribute("khachhang_id", khachhang_id);
		return "khachhang/allmathang_thuonghieu";
	}
	
	@GetMapping("/huydon")
	public String HuyDon(@RequestParam String donhangId, @RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
		int donhang_id = Integer.parseInt(donhangId);
		
		Optional<DonHang> donhangfind = donhangRepository.findById(donhang_id);
		DonHang donhang = donhangfind.get();
		Optional<TrangThaiDH> trangthaidonhang = trangthaidhRepository.findById(4);
		donhang.setTrangthaidh(trangthaidonhang.get());
		donhangRepository.save(donhang);
		
		return "redirect:/home?khachhang_id=" + khachhang_id; 
	}
	@GetMapping("/hoanthanh")
	public String HoanThanhDonHang(@RequestParam String donhangId, @RequestParam String khachhangId) {
		
		int khachhang_id = Integer.parseInt(khachhangId);
		int donhang_id = Integer.parseInt(donhangId);
		
		Optional<DonHang> donhangfind = donhangRepository.findById(donhang_id);
		DonHang donhang = donhangfind.get();
		Optional<TrangThaiDH> trangthaidonhang = trangthaidhRepository.findById(3);
		donhang.setTrangthaidh(trangthaidonhang.get());
		donhangRepository.save(donhang);
		
		return "redirect:/home?khachhang_id=" + khachhang_id; 
	}
}

