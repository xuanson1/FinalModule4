package com.example.onlinesales.services;

import com.example.onlinesales.models.LoaiSanPham;
import com.example.onlinesales.repositories.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanPhamService {

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    public List<LoaiSanPham> findAll() {
        return loaiSanPhamRepository.findAll();
    }

    public LoaiSanPham findById(Long id) {
        return loaiSanPhamRepository.findById(id).orElse(null);
    }

    public LoaiSanPham save(LoaiSanPham loaiSanPham) {
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    public LoaiSanPham update(Long id, LoaiSanPham loaiSanPhamDetails) {
        LoaiSanPham loaiSanPham = findById(id);
        loaiSanPham.setTenLoaiSp(loaiSanPhamDetails.getTenLoaiSp());
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    public void delete(Long id) {
        LoaiSanPham loaiSanPham = findById(id);
        loaiSanPhamRepository.delete(loaiSanPham);
    }
}

