package com.website.ThoiTrangOnline.ModelDto;

import java.time.LocalDate;

public class DoanhThuLuotBanDto {
	
	private LocalDate ngayhientai;
	private int doanhthu;
	private int sodonhang;
	private int somathang;
	private double tiledoanhthu;
	private double tilesodonhang;
	private double tilesomathang;
	
	
	public int getDoanhthu() {
		return doanhthu;
	}
	public void setDoanhthu(int doanhthu) {
		this.doanhthu = doanhthu;
	}
	public int getSodonhang() {
		return sodonhang;
	}
	public void setSodonhang(int sodonhang) {
		this.sodonhang = sodonhang;
	}
	public int getSomathang() {
		return somathang;
	}
	public void setSomathang(int somathang) {
		this.somathang = somathang;
	}
	public LocalDate getNgayhientai() {
		return ngayhientai;
	}
	public void setNgayhientai(LocalDate ngayhientai) {
		this.ngayhientai = ngayhientai;
	}
	public double getTiledoanhthu() {
		return tiledoanhthu;
	}
	public void setTiledoanhthu(double tiledoanhthu) {
		this.tiledoanhthu = tiledoanhthu;
	}
	public double getTilesodonhang() {
		return tilesodonhang;
	}
	public void setTilesodonhang(double tilesodonhang) {
		this.tilesodonhang = tilesodonhang;
	}
	public double getTilesomathang() {
		return tilesomathang;
	}
	public void setTilesomathang(double tilesomathang) {
		this.tilesomathang = tilesomathang;
	}
	
}
