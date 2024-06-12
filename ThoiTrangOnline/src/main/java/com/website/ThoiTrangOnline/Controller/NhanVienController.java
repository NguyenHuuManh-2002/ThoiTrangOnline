package com.website.ThoiTrangOnline.Controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
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
import com.website.ThoiTrangOnline.ModelDto.MatHangCreateDto;
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

	@GetMapping("/createmathang")
	public String showCreatePage(Model model) {
		MatHangCreateDto mathangCreateDto = new MatHangCreateDto();
		model.addAttribute("mathangCreateDto", mathangCreateDto);
		return "nhanvien/CreateProduct";

	}

	@PostMapping("/createmathang")
	public String createProduct(@Valid @ModelAttribute MatHangCreateDto mathangCreateDto, BindingResult result) {

		if (mathangCreateDto.getImageFile().isEmpty()) {
			result.addError(new FieldError("mathangCreateDto", "imageFile", "The image file is required"));
		}

		if (result.hasErrors()) {
			return "nhanvien/CreateProduct";
		}

		// save image file
		MultipartFile image = mathangCreateDto.getImageFile();
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
		
		
		Optional<DanhMuc> danhmuc = danhmucRepository.findByTen(mathangCreateDto.getDanhmuc()); 
		Optional<ThuongHieu> thuonghieu = thuonghieuRepository.findByTen(mathangCreateDto.getThuonghieu()); 
		
		MatHang mathang = new MatHang();
		mathang.setTen(mathangCreateDto.getTen());
		mathang.setGia(mathangCreateDto.getGia());
		mathang.setSoluong(mathangCreateDto.getConlai());
		mathang.setDanhmuc(danhmuc.get());
		mathang.setThuonghieu(thuonghieu.get());
		mathang.setGia(mathangCreateDto.getGia());
		mathang.setMota(mathangCreateDto.getMota());
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

			MatHangCreateDto mathangCreateDto = new MatHangCreateDto();
			mathangCreateDto.setTen(mathang.getTen());
			mathangCreateDto.setGia(mathang.getGia());
			mathangCreateDto.setConlai(mathang.getSoluong());
			mathangCreateDto.setDanhmuc(mathang.getDanhmuc().getTen());
			mathangCreateDto.setThuonghieu(mathang.getThuonghieu().getTen());
			mathangCreateDto.setGia(mathang.getGia());
			mathangCreateDto.setMota(mathang.getMota());

			model.addAttribute("mathangCreateDto", mathangCreateDto);
			
		} catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/nhanvien/mathang";
		}
		return "nhanvien/EditProduct";
	}

	@PostMapping("/editmathang")
	public String updateProduct(Model model, @RequestParam int id, @Valid @ModelAttribute MatHangCreateDto mathangCreateDto,
			BindingResult result) {
		try {
			MatHang mathang = mathangRepository.findById(id).get();
			model.addAttribute("mathang", mathang);
			if (result.hasErrors()) {
				return "nhanvien/EditProduct";
			}

			if (!mathangCreateDto.getImageFile().isEmpty()) {
				// delete old image
				String uploadDir = "static/image/mathang/";
				Path oldImagePath = Paths.get(uploadDir + mathang.getImgmathang());

				try {
					Files.delete(oldImagePath);
				} catch (Exception ex) {
					System.out.println("Exception:" + ex.getMessage());
				}
				// save new image file
				MultipartFile image = mathangCreateDto.getImageFile();
				String originalFileName = image.getOriginalFilename();
			    String storageFileName = originalFileName;
				
				try (InputStream inputStream = image.getInputStream()) {
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
							StandardCopyOption.REPLACE_EXISTING);
				}
				mathang.setImgmathang(storageFileName);
			}
			Optional<DanhMuc> danhmuc = danhmucRepository.findByTen(mathangCreateDto.getDanhmuc()); 
			Optional<ThuongHieu> thuonghieu = thuonghieuRepository.findByTen(mathangCreateDto.getThuonghieu()); 
	
			mathang.setTen(mathangCreateDto.getTen());
			mathang.setGia(mathangCreateDto.getGia());
			mathang.setSoluong(mathangCreateDto.getConlai());
			mathang.setDanhmuc(danhmuc.get());
			mathang.setThuonghieu(thuonghieu.get());
			mathang.setGia(mathangCreateDto.getGia());
			mathang.setMota(mathangCreateDto.getMota());

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
