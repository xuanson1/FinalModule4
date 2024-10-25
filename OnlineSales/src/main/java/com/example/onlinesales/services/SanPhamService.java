package com.example.onlinesales.services;

import com.example.onlinesales.models.SanPham;
import com.example.onlinesales.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    public SanPham findById(Long id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    public SanPham save(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public SanPham update(Long id, SanPham sanPhamDetails) {
        SanPham sanPham = findById(id);
        sanPham.setTenSp(sanPhamDetails.getTenSp());
        sanPham.setGiaSp(sanPhamDetails.getGiaSp());
        sanPham.setTinhTrangSp(sanPhamDetails.getTinhTrangSp());
        sanPham.setLoaiSanPham(sanPhamDetails.getLoaiSanPham());
        return sanPhamRepository.save(sanPham);
    }

    public void delete(Long id) {
        SanPham sanPham = findById(id);
        sanPhamRepository.delete(sanPham);
    }
}