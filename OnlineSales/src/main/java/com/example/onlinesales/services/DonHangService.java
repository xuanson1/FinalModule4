package com.example.onlinesales.services;

import com.example.onlinesales.models.DonHang;
import com.example.onlinesales.repositories.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonHangService {

    @Autowired
    private DonHangRepository donHangRepository;

    public List<DonHang> findAll() {
        return donHangRepository.findAll();
    }

    public DonHang findById(Long id) {
        return donHangRepository.findById(id).orElse(null);
    }

    public DonHang save(DonHang donHang) {
        return donHangRepository.save(donHang);
    }

    public DonHang update(DonHang donHangDetails) {
        return donHangRepository.save(donHangDetails);
    }

    public void delete(Long id) {
        DonHang donHang = findById(id);
        donHangRepository.delete(donHang);
    }
    public List<DonHang> findTopDonHangs() {
        return donHangRepository.findTopByOrderByTongTienDesc();
    }
    public List<DonHang> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return donHangRepository.findByDateRange(startDate, endDate);
    }
}
