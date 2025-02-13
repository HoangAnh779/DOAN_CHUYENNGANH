package com.webtourdl.WebTourDuLich.service;

import com.webtourdl.WebTourDuLich.dto.BookingDTO;
import com.webtourdl.WebTourDuLich.dto.BookingDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingService {

	Page<BookingDTO> findAllBooking(Integer trang_thai,String ten_tour,Pageable pageable);
	
	List<BookingDTO> findBookingByUserId(Long userId);
	
	Page<BookingDTO> findBookingByTourId(Long tour_Id,Pageable pageable);
	
	boolean addNewBooking(BookingDTO newBooking);
	
	boolean approveBooking(Long bookingId,Integer trang_thai);

	boolean deleteBooking(Long id);

	BookingDTO getBookingById(Long id);

	BookingDetailDTO getBookingDetailById(Long id);

	List<BookingDTO> findBookingByUserIdAndTourName(Long userId, String tenTour);

	public long countBookings();

	long calculateTotalRevenue();

	Double getTotalRevenueByDateRange(Timestamp startDate, Timestamp endDate);
}
