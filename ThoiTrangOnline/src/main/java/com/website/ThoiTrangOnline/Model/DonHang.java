package com.website.ThoiTrangOnline.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="donhang")
public class DonHang {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int soluong;
	private int tongtien;
	private LocalDate ngaydat;
	
	@ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false)
    private KhachHang khachhang;
	
	@ManyToOne
    @JoinColumn(name = "mathang_id", nullable = false)
    private MatHang mathang;
	
	@ManyToOne
    @JoinColumn(name = "phuongthuctt_id", nullable = false)
    private PhuongThucTT phuongthuctt;
	
	@ManyToOne
    @JoinColumn(name = "trangthaidh_id", nullable = false)
    private TrangThaiDH trangthaidh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public LocalDate getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(LocalDate ngaydat) {
		this.ngaydat = ngaydat;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public MatHang getMathang() {
		return mathang;
	}

	public void setMathang(MatHang mathang) {
		this.mathang = mathang;
	}

	public PhuongThucTT getPhuongthuctt() {
		return phuongthuctt;
	}

	public void setPhuongthuctt(PhuongThucTT phuongthuctt) {
		this.phuongthuctt = phuongthuctt;
	}

	public TrangThaiDH getTrangthaidh() {
		return trangthaidh;
	}

	public void setTrangthaidh(TrangThaiDH trangthaidh) {
		this.trangthaidh = trangthaidh;
	}
	
	
}
