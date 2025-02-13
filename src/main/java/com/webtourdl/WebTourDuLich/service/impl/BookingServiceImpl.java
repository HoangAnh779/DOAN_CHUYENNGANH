package com.webtourdl.WebTourDuLich.service.impl;

import com.webtourdl.WebTourDuLich.dto.BookingDTO;
import com.webtourdl.WebTourDuLich.dto.BookingDetailDTO;
import com.webtourdl.WebTourDuLich.dto.TourDTO;
import com.webtourdl.WebTourDuLich.entity.Booking;
import com.webtourdl.WebTourDuLich.repository.BookingRepository;
import com.webtourdl.WebTourDuLich.repository.TourRepository;
import com.webtourdl.WebTourDuLich.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private TourRepository tourRepository;

	@Override
	public Page<BookingDTO> findAllBooking(Integer trang_thai,String ten_tour,Pageable pageable) {
		return this.bookingRepository.findAllBooking(trang_thai,ten_tour, pageable);
	}

	@Override
	public List<BookingDTO> findBookingByUserId(Long userId) {
		return this.bookingRepository.findBookingByUserId(userId);
	}

	@Override
	public Page<BookingDTO> findBookingByTourId(Long tour_Id,Pageable pageable) {
		return this.bookingRepository.findBookingByTourId(tour_Id, pageable);
	}

//	@Override
//	public boolean addNewBooking(BookingDTO newBooking) {
//
//
//		List<BookingDTO> checkBooking  = this.bookingRepository.checkBookingByUserId(newBooking.getUser_id());
//		if(checkBooking.size()>0) {
//			return false;
//		}
//
//		TourDTO tourDTO = this.tourRepository.findTourById(newBooking.getTour_id());
//
//		Booking booking = new Booking();
//		booking.setSo_luong_nguoi(newBooking.getSo_luong_nguoi());
//		booking.setNgay_khoi_hanh(newBooking.getNgay_khoi_hanh());
//		booking.setTong_tien(tourDTO.getGia_tour()*newBooking.getSo_luong_nguoi());
//		booking.setTour_id(newBooking.getTour_id());
//		booking.setUser_id(newBooking.getUser_id());
//		booking.setSo_luong_nguoi(newBooking.getSo_luong_nguoi());
//		booking.setGhi_chu(newBooking.getGhi_chu());
//		booking.setPt_thanh_toan(newBooking.getPt_thanh_toan());
//		booking.setTrang_thai(0);
//
//		this.bookingRepository.save(booking);
//
//		return true;
//	}

	@Override
	public boolean addNewBooking(BookingDTO newBooking) {

		// Kiểm tra xem user đã có booking nào hay chưa
		List<BookingDTO> checkBooking = this.bookingRepository.checkBookingByUserId(newBooking.getUser_id());
		if (checkBooking.size() > 0) {
			return false;
		}

		// Lấy thông tin tour từ repository
		TourDTO tourDTO = this.tourRepository.findTourById(newBooking.getTour_id());

		// Tính tổng tiền trước khi áp dụng giảm giá
		long tongTien = tourDTO.getGia_tour() * newBooking.getSo_luong_nguoi();

		// Áp dụng giảm giá nếu người dùng có nhập mã giảm giá hợp lệ
		if (tourDTO.getMa_giam_gia() != null && !tourDTO.getMa_giam_gia().isEmpty()) {
			if (tourDTO.getGiam_gia() != null && tourDTO.getGiam_gia() > 0) {
				tongTien -= (tongTien * tourDTO.getGiam_gia() / 100);
			}
		}

		// Tạo booking mới
		Booking booking = new Booking();
		booking.setSo_luong_nguoi(newBooking.getSo_luong_nguoi());
		booking.setNgay_khoi_hanh(newBooking.getNgay_khoi_hanh());
		booking.setTong_tien(tongTien); // Đặt tổng tiền đã được giảm giá
		booking.setTour_id(newBooking.getTour_id());
		booking.setUser_id(newBooking.getUser_id());
		booking.setSo_luong_nguoi(newBooking.getSo_luong_nguoi());
		booking.setGhi_chu(newBooking.getGhi_chu());
		booking.setPt_thanh_toan(newBooking.getPt_thanh_toan());
		booking.setTrang_thai(0); // Trạng thái mặc định

		// Lưu booking vào cơ sở dữ liệu
		this.bookingRepository.save(booking);

		return true;
	}


	@SuppressWarnings("deprecation")
	@Override
	public boolean approveBooking(Long bookingId,Integer trang_thai) {
		Optional<Booking> booking  = this.bookingRepository.findById(bookingId);

		if(booking.isPresent()) {
			Booking bookingUpdated = booking.get();
			bookingUpdated.setTrang_thai(trang_thai);
			this.bookingRepository.save(bookingUpdated);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteBooking(Long id) {

		BookingDTO booking = this.getBookingById(id);

		if(booking.getTrang_thai()==3) {
			this.bookingRepository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public BookingDTO getBookingById(Long id) {
		return this.bookingRepository.findBookingById(id);
	}

	@Override
	public BookingDetailDTO getBookingDetailById(Long id) {
		return this.bookingRepository.findBookingDetailById(id);
	}

	@Override
	public List<BookingDTO> findBookingByUserIdAndTourName(Long userId, String tenTour) {
		return this.bookingRepository.findBookingByUserIdAndTourNameContaining(userId, tenTour);
	}

	@Override
	public long countBookings() {
		return bookingRepository.count();
	}

	@Override
	public long calculateTotalRevenue() {
		return bookingRepository.calculateTotalRevenue();
	}

	@Override
	public Double getTotalRevenueByDateRange(Timestamp startDate, Timestamp endDate) {
		// Gọi repository để lấy tổng doanh thu trong khoảng thời gian
		return bookingRepository.getTotalRevenueByDateRange(startDate, endDate);
	}
}
