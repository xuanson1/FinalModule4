package com.example.onlinesales.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private Long maDonHang;
    @Column(name = "ngay_mua")
    private LocalDateTime ngayMua;
    @Column(name = "so_luong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_sp")
    private SanPham sanPham;


    public Long getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Long maDonHang) {
        this.maDonHang = maDonHang;
    }

    public LocalDateTime getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDateTime ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    @Transient
    public double getTongTien() {
        return sanPham.getGiaSp() * soLuong;
    }
}