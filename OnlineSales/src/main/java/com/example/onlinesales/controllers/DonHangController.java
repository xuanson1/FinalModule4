package com.example.onlinesales.controllers;

import com.example.onlinesales.models.DonHang;
import com.example.onlinesales.services.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/donhang")
public class DonHangController {

    @Autowired
    private DonHangService donHangService;


    @GetMapping
    public String getAllDonHang(Model model) {
        List<DonHang> donHangs = donHangService.findAll();
        model.addAttribute("donHangs", donHangs);
        return "donhang/list";
    }

    // Hiển thị trang tạo đơn hàng
    @GetMapping("/create")
    public String createDonHangPage(Model model) {
        model.addAttribute("donHang", new DonHang());
        return "donhang/create";
    }

    // Xử lý tạo đơn hàng
    @PostMapping
    public String createDonHang(@ModelAttribute DonHang donHang) {
        donHangService.save(donHang);
        return "redirect:/donhang";
    }

    // Hiển thị trang cập nhật đơn hàng
    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        DonHang donHang = donHangService.findById(id);
        if (donHang != null) {
            model.addAttribute("donHang", donHang);
        } else {
            // xử lý nếu không tìm thấy donHang
        }
        return "donhang/update";
    }


    // Xử lý cập nhật đơn hàng
    @PostMapping("/update")
    public String updateDonHang(@ModelAttribute("donHang") DonHang donHang) {
        donHangService.update(donHang);
        return "redirect:/donhang";
    }

    @GetMapping("/top")
    public String listTopDonHang(Model model) {
        List<DonHang> donHangs = donHangService.findTopDonHangs();
        model.addAttribute("donHangs", donHangs);
        return "donhang/list";
    }

    @GetMapping("/filter")
    public String filterDonHang(@RequestParam("startDate") String startDateStr,
                                @RequestParam("endDate") String endDateStr,
                                Model model) {
        LocalDateTime startDate = LocalDateTime.parse(startDateStr + "T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(endDateStr + "T23:59:59");

        List<DonHang> donHangs = donHangService.findByDateRange(startDate, endDate);
        model.addAttribute("donHangs", donHangs);
        return "donhang/list"; // Trả về template hiển thị danh sách đơn hàng đã lọc
    }
}

