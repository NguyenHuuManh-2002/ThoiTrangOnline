package com.website.ThoiTrangOnline.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.website.ThoiTrangOnline.Model.DanhMuc;
import com.website.ThoiTrangOnline.Model.DonHang;
import com.website.ThoiTrangOnline.Model.KhachHang;
import com.website.ThoiTrangOnline.Model.MatHang;
import com.website.ThoiTrangOnline.Model.PhuongThucTT;
import com.website.ThoiTrangOnline.Model.ThuongHieu;
import com.website.ThoiTrangOnline.Model.TrangThaiDH;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {

    List<DonHang> findByKhachhang(KhachHang khachhang);
    
    List<DonHang> findByKhachhangAndTrangthaidh(KhachHang khachhang, TrangThaiDH trangthaidh);

    List<DonHang> findByMathangAndTrangthaidh_id(MatHang mathang, int trangthaidh);

    List<DonHang> findByNgaydatBetweenAndTrangthaidh_id(LocalDate start, LocalDate end, int trangthaidh);

    List<DonHang> findByMathang_DanhmucAndTrangthaidh_id(DanhMuc danhmuc, int trangthaidh);

    List<DonHang> findByMathang_ThuonghieuAndTrangthaidh_id(ThuongHieu thuonghieu, int trangthaidh);

    List<DonHang> findByMathangAndNgaydatBetweenAndTrangthaidh_id(MatHang mathang, LocalDate start, LocalDate end,
                                                                   int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.mathang = :mathang AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathangAndNgaydatMonthAndTrangthaidh_id(@Param("mathang") MatHang mathang,
                                                                 @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.mathang = :mathang AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathangAndNgaydatYearAndTrangthaidh_id(@Param("mathang") MatHang mathang,
                                                                @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    List<DonHang> findByMathang_DanhmucAndNgaydatBetweenAndTrangthaidh_id(DanhMuc danhmuc, LocalDate start,
                                                                          LocalDate end, int trangthaidh);

    @Query("SELECT dh FROM DonHang dh JOIN dh.mathang mh JOIN mh.danhmuc dm WHERE dm = :danhmuc AND MONTH(dh.ngaydat) = :month AND dh.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathang_DanhmucAndNgaydatMonthAndTrangthaidh_id(@Param("danhmuc") DanhMuc danhmuc,
                                                                         @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT dh FROM DonHang dh JOIN dh.mathang mh JOIN mh.danhmuc dm WHERE dm = :danhmuc AND YEAR(dh.ngaydat) = :year AND dh.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathang_DanhmucAndNgaydatYearAndTrangthaidh_id(@Param("danhmuc") DanhMuc danhmuc,
                                                                        @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    List<DonHang> findByMathang_ThuonghieuAndNgaydatBetweenAndTrangthaidh_id(ThuongHieu thuonghieu, LocalDate start,
                                                                             LocalDate end, int trangthaidh);

    @Query("SELECT dh FROM DonHang dh JOIN dh.mathang mh JOIN mh.thuonghieu th WHERE th = :thuonghieu AND MONTH(dh.ngaydat) = :month AND dh.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathang_ThuonghieuAndNgaydatMonthAndTrangthaidh_id(@Param("thuonghieu") ThuongHieu thuonghieu,
                                                                            @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT dh FROM DonHang dh JOIN dh.mathang mh JOIN mh.thuonghieu th WHERE th = :thuonghieu AND YEAR(dh.ngaydat) = :year AND dh.trangthaidh.id = :trangthaidh")
    List<DonHang> findByMathang_ThuonghieuAndNgaydatYearAndTrangthaidh_id(@Param("thuonghieu") ThuongHieu thuonghieu,
                                                                           @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    List<DonHang> findByKhachhangAndTrangthaidh_id(KhachHang khachhang, int trangthaidh);

    List<DonHang> findByKhachhangAndNgaydatBetweenAndTrangthaidh_id(KhachHang khachhang, LocalDate start, LocalDate end,
                                                                    int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.khachhang = :khachhang AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByKhachhangAndNgaydatMonthAndTrangthaidh_id(@Param("khachhang") KhachHang khachhang,
                                                                   @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.khachhang = :khachhang AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByKhachhangAndNgaydatYearAndTrangthaidh_id(@Param("khachhang") KhachHang khachhang,
                                                                  @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    List<DonHang> findByTongtienLessThanAndTrangthaidh_id(int amount, int trangthaidh);

    List<DonHang> findByTongtienBetweenAndTrangthaidh_id(int minAmount, int maxAmount, int trangthaidh);

    List<DonHang> findByTongtienGreaterThanAndTrangthaidh_id(int amount, int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien < :amount AND d.ngaydat BETWEEN :start AND :end AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienLessThanAndNgaydatBetweenAndTrangthaidh_id(@Param("amount") int amount,
                                                                            @Param("start") LocalDate start, @Param("end") LocalDate end, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien BETWEEN :minAmount AND :maxAmount AND d.ngaydat BETWEEN :start AND :end AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienBetweenAndNgaydatBetweenAndTrangthaidh_id(@Param("minAmount") int minAmount,
                                                                           @Param("maxAmount") int maxAmount, @Param("start") LocalDate start, @Param("end") LocalDate end, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien > :amount AND d.ngaydat BETWEEN :start AND :end AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienGreaterThanAndNgaydatBetweenAndTrangthaidh_id(@Param("amount") int amount,
                                                                               @Param("start") LocalDate start, @Param("end") LocalDate end, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien < :amount AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienLessThanAndNgaydatMonthAndTrangthaidh_id(@Param("amount") int amount,
                                                                          @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien BETWEEN :minAmount AND :maxAmount AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienBetweenAndNgaydatMonthAndTrangthaidh_id(@Param("minAmount") int minAmount,
                                                                         @Param("maxAmount") int maxAmount, @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien > :amount AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienGreaterThanAndNgaydatMonthAndTrangthaidh_id(@Param("amount") int amount,
                                                                             @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien < :amount AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienLessThanAndNgaydatYearAndTrangthaidh_id(@Param("amount") int amount,
                                                                         @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien BETWEEN :minAmount AND :maxAmount AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienBetweenAndNgaydatYearAndTrangthaidh_id(@Param("minAmount") int minAmount,
                                                                        @Param("maxAmount") int maxAmount, @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.tongtien > :amount AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByTongtienGreaterThanAndNgaydatYearAndTrangthaidh_id(@Param("amount") int amount,
                                                                            @Param("year") int year, @Param("trangthaidh") int trangthaidh);

    List<DonHang> findByPhuongthucttAndTrangthaidh_id(PhuongThucTT phuongthuctt, int trangthaidh);

    List<DonHang> findByPhuongthucttAndNgaydatBetweenAndTrangthaidh_id(PhuongThucTT phuongthuctt, LocalDate start,
                                                                       LocalDate end, int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.phuongthuctt = :phuongthuctt AND MONTH(d.ngaydat) = :month AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByPhuongthucttAndNgaydatMonthAndTrangthaidh_id(@Param("phuongthuctt") PhuongThucTT phuongthuctt,
                                                                      @Param("month") int month, @Param("trangthaidh") int trangthaidh);

    @Query("SELECT d FROM DonHang d WHERE d.phuongthuctt = :phuongthuctt AND YEAR(d.ngaydat) = :year AND d.trangthaidh.id = :trangthaidh")
    List<DonHang> findByPhuongthucttAndNgaydatYearAndTrangthaidh_id(@Param("phuongthuctt") PhuongThucTT phuongthuctt,
                                                                     @Param("year") int year, @Param("trangthaidh") int trangthaidh);

}
