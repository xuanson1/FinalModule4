package com.example.onlinesales.repositories;




import com.example.onlinesales.models.DonHang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, Long> {
    List<DonHang> findByNgayMuaBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT dh FROM DonHang dh ORDER BY (dh.soLuong * dh.sanPham.giaSp) DESC")
    List<DonHang> findTopByOrderByTongTienDesc();
}


