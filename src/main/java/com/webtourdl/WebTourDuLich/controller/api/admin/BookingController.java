package com.webtourdl.WebTourDuLich.controller.api.admin;

import com.webtourdl.WebTourDuLich.dto.BookingDTO;
import com.webtourdl.WebTourDuLich.dto.ResponseDTO;
import com.webtourdl.WebTourDuLich.service.BookingService;
import com.webtourdl.WebTourDuLich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAllBooking")
    public ResponseDTO getAllBooking(@RequestParam(value="trang_thai",required = false) Integer trang_thai,
                                     @RequestParam(value = "trang_thai",required = false) String ten_tour,
                                     @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize,
                                     @RequestParam("pageIndex") Integer pageIndex){


        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        Page<BookingDTO> page = this.bookingService.findAllBooking(trang_thai,ten_tour, PageRequest.of(pageIndex,pageSize));

        return new ResponseDTO("Thành công",page.getContent());

    }

    @GetMapping("/{id}")
    public ResponseDTO getOneBooking(@PathVariable("id") Long id) {
        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }
        return new ResponseDTO("Thành công",this.bookingService.getBookingById(id));
    }
    @GetMapping("/detail/{id}")
    public ResponseDTO getOneDetailBooking(@PathVariable("id") Long id) {
        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }
        return new ResponseDTO("Thành công",this.bookingService.getBookingDetailById(id));
    }

    @PutMapping("/approve/{id}")
    public ResponseDTO changeStatus(@PathVariable("id") Long id,@RequestParam("trang_thai") Integer trang_thai) {

        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        if(this.bookingService.approveBooking(id,trang_thai)) {
            return new ResponseDTO("Cập nhật thành công",null);
        }
        return new ResponseDTO("Cập nhật thất bại",null);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteBooking(@PathVariable("id") Long id) {

        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        if(this.bookingService.deleteBooking(id)) {
            return new ResponseDTO("Xóa thành công",null);
        }

        return new ResponseDTO("Chỉ có thể xóa tour đã hoàn thành và đã hủy",null);
    }

    // Đếm booking
    @GetMapping("/count")
    public ResponseDTO getBookingCount() {
        long bookingCount = bookingService.countBookings();
        Map<String, Long> response = new HashMap<>();
        response.put("count", bookingCount);
        return new ResponseDTO("Thành công", response);
    }

    @GetMapping("/total-revenue")
    public ResponseDTO getTotalRevenue() {
        if (!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập", null);
        }

        // Gọi service để tính tổng doanh thu
        long totalRevenue = this.bookingService.calculateTotalRevenue();

        Map<String, Long> response = new HashMap<>();
        response.put("totalRevenue", totalRevenue);

        return new ResponseDTO("Thành công", response);
    }

    @GetMapping("/total-revenue-date")
    public Map<String, Object> getTotalRevenueByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Chuyển đổi LocalDate thành Timestamp
            Timestamp startTimestamp = Timestamp.valueOf(startDate.atStartOfDay());
            Timestamp endTimestamp = Timestamp.valueOf(endDate.atStartOfDay().plusDays(1).minusNanos(1)); // Đảm bảo thời gian cuối ngày là 23:59:59.999999999

            // Gọi service để tính doanh thu
            Double totalRevenue = bookingService.getTotalRevenueByDateRange(startTimestamp, endTimestamp);
            response.put("data", totalRevenue != null ? totalRevenue : 0);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Lỗi khi tính tổng doanh thu: " + e.getMessage());
        }
        return response;
    }

}
