package com.website.ThoiTrangOnline.Controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.ModelDto.MatHangDto;
import com.website.ThoiTrangOnline.ModelDto.ThuongHieuDto;
import com.website.ThoiTrangOnline.Repository.DanhMucRepository;
import com.website.ThoiTrangOnline.Repository.MatHangRepository;
import com.website.ThoiTrangOnline.Repository.ThuongHieuRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

	@Autowired
	private MatHangRepository mathangRepository;
	@Autowired
	private DanhMucRepository danhmucRepository;
	@Autowired
	private ThuongHieuRepository thuonghieuRepository;
	
	@GetMapping("/mathang")
	public String showProductList(Model model) {

		List<MatHang> mathangs = mathangRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("mathangs", mathangs);

		return "nhanvien/listProduct";

	}

	@GetMapping({ "/createmathang" })
	public String showCreatePage(Model model) {
		MatHangDto mathangDto = new MatHangDto();
		model.addAttribute("mathangDto", mathangDto);
		return "/nhanvien/CreateProduct";

	}

	@PostMapping("/createmathang")
	public String createProduct(@Valid @ModelAttribute MatHangDto mathangDto, BindingResult result) {

		if (mathangDto.getImgmathang().isEmpty()) {
			result.addError(new FieldError("mathangDto", "imageFile", "The image file is required"));
		}

		if (result.hasErrors()) {
			return "nhanvien/CreateProduct";
		}

		// save image file
		MultipartFile image = mathangDto.getImageFile();
		LocalDate ngaytao = LocalDate.now();
		String originalFileName = image.getOriginalFilename();
	    String storageFileName = originalFileName;

		try {
			String uploadDir = "static/image/mathang/";
			Path uploadPath = Paths.get(uploadDir);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try (InputStream inputStream = image.getInputStream()) {
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		
		int danhmucId = Integer.parseInt(mathangDto.getDanhmuc());
		Optional<DanhMuc> danhmuc = danhmucRepository.findById(danhmucId); 
		int thuonghieuId = Integer.parseInt(mathangDto.getThuonghieu());
		Optional<ThuongHieu> thuonghieu = thuonghieuRepository.findById(thuonghieuId); 
		
		MatHang mathang = new MatHang();
		mathang.setTen(mathangDto.getTen());
		mathang.setGia(mathangDto.getGia());
		mathang.setSoluong(mathangDto.getConlai());
		mathang.setDanhmuc(danhmuc.get());
		mathang.setThuonghieu(thuonghieu.get());
		mathang.setGia(mathangDto.getGia());
		mathang.setMota(mathangDto.getMota());
		mathang.setNgaytao(ngaytao);
		mathang.setImgmathang(storageFileName);

		mathangRepository.save(mathang);

		return "redirect:/nhanvien/mathang";

	}

	@GetMapping("/editmathang")
	public String showEditPage(Model model, @RequestParam int id) {
		try {
			MatHang mathang = mathangRepository.findById(id).get();
			model.addAttribute("mathang", mathang);

			MatHangDto mathangDto = new MatHangDto();
			mathangDto.setTen(mathang.getTen());
			mathangDto.setGia(mathang.getGia());
			mathangDto.setConlai(mathang.getSoluong());
			mathangDto.setDanhmuc(mathang.getDanhmuc().getTen());
			mathangDto.setThuonghieu(mathang.getThuonghieu().getTen());
			mathangDto.setGia(mathang.getGia());
			mathangDto.setMota(mathang.getMota());

			model.addAttribute("mathangDto", mathangDto);
			
		} catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/nhanvien/mathang";
		}
		return "nhanvien/EditProduct";
	}

	@PostMapping("/editmathang")
	public String updateProduct(Model model, @RequestParam int id, @Valid @ModelAttribute MatHangDto mathangDto,
			BindingResult result) {
		try {
			MatHang mathang = mathangRepository.findById(id).get();
			model.addAttribute("mathang", mathang);
			if (result.hasErrors()) {
				return "nhanvien/EditProduct";
			}

			if (!mathangDto.getImageFile().isEmpty()) {
				// delete old image
				String uploadDir = "static/image/mathang/";
				Path oldImagePath = Paths.get(uploadDir + mathang.getImgmathang());

				try {
					Files.delete(oldImagePath);
				} catch (Exception ex) {
					System.out.println("Exception:" + ex.getMessage());
				}
				// save new image file
				MultipartFile image = mathangDto.getImageFile();
				String originalFileName = image.getOriginalFilename();
			    String storageFileName = originalFileName;
				
				try (InputStream inputStream = image.getInputStream()) {
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
							StandardCopyOption.REPLACE_EXISTING);
				}
				mathang.setImgmathang(storageFileName);
			}
			int danhmucId = Integer.parseInt(mathangDto.getDanhmuc());
			Optional<DanhMuc> danhmuc = danhmucRepository.findById(danhmucId); 
			int thuonghieuId = Integer.parseInt(mathangDto.getThuonghieu());
			Optional<ThuongHieu> thuonghieu = thuonghieuRepository.findById(thuonghieuId); 
	
			mathang.setTen(mathangDto.getTen());
			mathang.setGia(mathangDto.getGia());
			mathang.setSoluong(mathangDto.getConlai());
			mathang.setDanhmuc(danhmuc.get());
			mathang.setThuonghieu(thuonghieu.get());
			mathang.setGia(mathangDto.getGia());
			mathang.setMota(mathangDto.getMota());

			mathangRepository.save(mathang);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
		return "redirect:/nhanvien/mathang";
	}

	@GetMapping("/deletemathang")
	public String deleteProduct(@RequestParam int id) {
		try {
			MatHang mathang = mathangRepository.findById(id).get();

			Path imagePath = Paths.get("static/image/mathang" + mathang.getImgmathang());
			try {
				Files.delete(imagePath);
			} catch (Exception ex) {
				System.out.println("Exception:" + ex.getMessage());
			}
			mathangRepository.delete(mathang);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
		return "redirect:/nhanvien/mathang";
	}
}
