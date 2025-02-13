package com.webtourdl.WebTourDuLich.controller;

import com.webtourdl.WebTourDuLich.dto.*;
import com.webtourdl.WebTourDuLich.entity.Image;
import com.webtourdl.WebTourDuLich.repository.ImageRepository;
import com.webtourdl.WebTourDuLich.repository.TourStartRepository;
import com.webtourdl.WebTourDuLich.service.BookingService;
import com.webtourdl.WebTourDuLich.service.TourService;
import com.webtourdl.WebTourDuLich.service.UserService;
import com.webtourdl.WebTourDuLich.utilities.SessionUtilities;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	public TourService tourService;

	@Autowired
	private TourStartRepository tourStartRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private HttpServletRequest request;


	@GetMapping("")
	ModelAndView index() {
		ModelAndView mdv = new ModelAndView("user/index");

		Page<TourDTO> tourPage = this.tourService.findAllTour(null, null, null, null, null, PageRequest.of(0, 6));

		List<TourDTO> tours = tourPage.getContent();

		mdv.addObject("tours", tours);


		return mdv;
	}

	@GetMapping("/tour/trong-nuoc")
	ModelAndView tourTrongNuoc(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
							   @RequestParam(value = "ten_tour", required = false) String ten_tour,
							   @RequestParam(value = "gia_tour", required = false) Long gia_tour,
							   @RequestParam(value = "ngay_khoi_hanh", required = false) String ngay_khoi_hanh) {
		ModelAndView mdv = new ModelAndView("user/tour1");
		Long gia_tour_from = null;
		Long gia_tour_to = null;
		if (gia_tour != null) {
			gia_tour_from = gia_tour == 0 ? null : (gia_tour == 1 ? 0 : (gia_tour == 2 ? 10000000l : 50000000l));

			gia_tour_to = gia_tour == 0 ? null : (gia_tour == 1 ? 10000000l : (gia_tour == 2 ? 50000000l : 500000000));
		}

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date ngay_khoi_hanh_value = null;
		try {
			ngay_khoi_hanh_value = ngay_khoi_hanh != null ? format.parse(ngay_khoi_hanh) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Page<TourDTO> tourPage = this.tourService.findAllTour(ten_tour, gia_tour_from, gia_tour_to,
				ngay_khoi_hanh_value, 1, PageRequest.of(pageIndex-1, 12));

		List<TourDTO> tours = tourPage.getContent();

		mdv.addObject("tours", tours);
		return mdv;
	}

	@GetMapping("/tour/ngoai-nuoc")
	ModelAndView tourNgoaiNuoc(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
							   @RequestParam(value = "ten_tour", required = false) String ten_tour,
							   @RequestParam(value = "gia_tour", required = false) Long gia_tour,
							   @RequestParam(value = "ngay_khoi_hanh", required = false) String ngay_khoi_hanh) {

		Long gia_tour_from = null;
		Long gia_tour_to = null;
		if (gia_tour != null) {
			gia_tour_from = gia_tour == 0 ? null : (gia_tour == 1 ? 0 : (gia_tour == 2 ? 10000000l : 50000000l));

			gia_tour_to = gia_tour == 0 ? null : (gia_tour == 1 ? 10000000l : (gia_tour == 2 ? 50000000l : 500000000l));
		}

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date ngay_khoi_hanh_value = null;
		try {
			ngay_khoi_hanh_value = ngay_khoi_hanh != null ? format.parse(ngay_khoi_hanh) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ModelAndView mdv = new ModelAndView("user/tour2");

		Page<TourDTO> tourPage = this.tourService.findAllTour(ten_tour, gia_tour_from, gia_tour_to, ngay_khoi_hanh_value, 2,
				PageRequest.of(pageIndex-1, 12));

		List<TourDTO> tours = tourPage.getContent();

		mdv.addObject("tours", tours);
		return mdv;
	}

	@GetMapping("/tour/{id}")
	ModelAndView tourDetail(@PathVariable(name = "id", required = true) Long id) {
		ModelAndView mdv = new ModelAndView("user/tour-detail");

		TourDTO tour = this.tourService.findTourById(id);
		List<Image> imageList = this.imageRepository.findByTourId(id);


		List<TourStartDTO> listDate = this.tourStartRepository.getDateStartByTourId(id);

		mdv.addObject("tour", tour);
		mdv.addObject("listDate", listDate);
		mdv.addObject("imageList", imageList);

		return mdv;
	}

	@GetMapping("/login")
	ModelAndView login() {
		if(this.userService.checkLogin()) {
			return this.account();
		}
		ModelAndView mdv = new ModelAndView("user/login");

		return mdv;
	}

	@GetMapping("/register")
	ModelAndView register() {

		if(this.userService.checkLogin()) {
			return this.account();
		}

		ModelAndView mdv = new ModelAndView("user/register");

		return mdv;
	}


	@PostMapping("/login")
	ModelAndView loginAction(LoginDTO login) {


		ModelAndView mdv = new ModelAndView("redirect:/account");

		if(!this.userService.login(login)) {
			ModelAndView mdvErr = new ModelAndView("user/login");
			mdvErr.addObject("err", "Sai thông tin đăng nhập");
			return mdvErr;
		}

		mdv.addObject("user", SessionUtilities.getUser());

		return mdv;
	}

	@PostMapping("/register")
	ModelAndView registerAction(RegisterDTO user) {


		ModelAndView mdv = new ModelAndView("user/login");

		if(!this.userService.register(user)) {
			ModelAndView mdvErr = new ModelAndView("user/register");
			mdvErr.addObject("err", "Đăng ký thất bại");
			return mdvErr;
		}
		mdv.addObject("message", "Đăng ký thành công vui lòng đăng nhập");
		return mdv;
	}

	@GetMapping("/logout")
	ModelAndView logout() {
		SessionUtilities.setUser(null);
		SessionUtilities.setUsername(null);
		return this.index();
	}

	@GetMapping("/account")
	ModelAndView account() {
		ModelAndView mdv = new ModelAndView();

		if(SessionUtilities.getUsername()==null) {
			ModelAndView loginView = new ModelAndView("redirect:/login");
			return loginView;
		}

		mdv.setViewName("user/account");
		mdv.addObject("user", SessionUtilities.getUser());

		return mdv;
	}

	@GetMapping("/changePassword")
	ModelAndView changePassword(ChangePasswordDTO changePasswordDTO) {

		ModelAndView mdv = new ModelAndView();
		if(!this.userService.checkLogin()) {
			mdv.setViewName("redirect:/login");
			return mdv;
		}
		mdv.setViewName("user/changepassword");
		return mdv;

	}

	@PostMapping("/changePassword")
	ModelAndView changePasswordAction(ChangePasswordDTO changePasswordDTO) {

		if(changePasswordDTO.getNewPassword()!=null && changePasswordDTO.getOldPassword()!=null) {
			if(this.userService.changePassword(changePasswordDTO)) {
				ModelAndView accountView = this.account();
				accountView.addObject("message","Thay đổi mật khẩu thành công");
				return accountView;
			}
		}

		ModelAndView mdv = new ModelAndView("user/changepassword");
		mdv.addObject("err","Mật khẩu cũ không đúng");

		return mdv;
	}

	@GetMapping("/forgotPassword")
	ModelAndView forgotPassword(ChangePasswordDTO changePasswordDTO) {
		// Không kiểm tra đăng nhập
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("user/forgotpassword");
		return mdv;
	}

	@PostMapping("/forgotPassword")
	ModelAndView forgotPasswordAction(ForgotPasswordDTO forgotPasswordDTO) {
		// Kiểm tra xem mật khẩu mới và email không được rỗng
		if (forgotPasswordDTO.getNewPassword() != null && forgotPasswordDTO.getYouremail() != null) {
			if (this.userService.forgotPassword(forgotPasswordDTO)) {
				ModelAndView accountView = new ModelAndView("user/login"); // Sau khi thành công, chuyển hướng đến trang đăng nhập
				accountView.addObject("message", "Thay đổi mật khẩu thành công. Vui lòng đăng nhập lại.");
				return accountView;
			}
		}

		// Nếu email không đúng hoặc mật khẩu mới rỗng, hiển thị lỗi
		ModelAndView mdv = new ModelAndView("user/forgotpassword");
		mdv.addObject("err", "Email không đúng hoặc không thể cập nhật mật khẩu.");
		return mdv;
	}

	@PostMapping("/updateAccount")
	ModelAndView updateAccountAction(UpdateUserDTO updateUserDTO) {

		log.info("update account:{}",updateUserDTO);

		if(this.userService.updateUser(updateUserDTO)) {
			return this.account().addObject("message","Cập nhật thành công!");
		}else {
			return this.account().addObject("message","Có lỗi xảy ra!");
		}

	}

	@GetMapping("/tour/booking/{id}")
	ModelAndView booking(@PathVariable("id") Long tour_id,
						 @RequestParam String ngay_khoi_hanh,
						 @RequestParam Integer so_nguoi,
						 @RequestParam Long tong_tien ) {

		log.info("ngay khoi hanh log: {}",ngay_khoi_hanh);
		ModelAndView mdv = new ModelAndView("user/booking-checkout");


		if(tour_id==null || ngay_khoi_hanh==null || so_nguoi==null || tong_tien==null) {
			return new ModelAndView("redirect:/err");
		}

		if(SessionUtilities.getUsername()==null) {
			ModelAndView loginView = new ModelAndView("redirect:/login");
			return loginView;
		}

		if(this.tourService.findTourById(tour_id)==null) {
			return new ModelAndView("redirect:/error");
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date ngay_khoi_hanh_value = null;
		try {
			ngay_khoi_hanh_value = ngay_khoi_hanh != null ? format.parse(ngay_khoi_hanh.split(" ")[0]) : null;
		} catch (ParseException e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/error");
		}

		mdv.addObject("user",SessionUtilities.getUser());
		TourDTO tour = this.tourService.findTourById(tour_id);
		mdv.addObject("tour",tour);
		mdv.addObject("ngay_khoi_hanh",ngay_khoi_hanh_value);
		mdv.addObject("so_nguoi",so_nguoi);
		mdv.addObject("tong_tien",tong_tien);

		return mdv;

	}

	@GetMapping("/momo/{id}")
	public ModelAndView momoPayment(@PathVariable("id") Long tourId,
									@RequestParam Long tong_tien) {
		log.info("Xử lý thanh toán MoMo cho tour ID: {}", tourId);

		// Khởi tạo ModelAndView
		ModelAndView modelAndView = new ModelAndView("user/momo");
		// Kiểm tra người dùng đã đăng nhập
		if (SessionUtilities.getUsername() == null) {
			return new ModelAndView("redirect:/login");
		}

		// Kiểm tra xem tour có tồn tại không
		TourDTO tour = this.tourService.findTourById(tourId);
		if (tour == null) {
			return new ModelAndView("redirect:/error");
		}


		// Thêm dữ liệu vào ModelAndView
		modelAndView.addObject("user", SessionUtilities.getUser());
		modelAndView.addObject("tour", tour);
		modelAndView.addObject("tong_tien", tong_tien);

		return modelAndView;
	}

	@PostMapping(value = "/tour/booking/{tour_id}")
	ModelAndView bookingAction(@PathVariable("tour_id") Long tour_id,
							   @RequestParam("so_luong_nguoi") Integer so_luong_nguoi,
							   @RequestParam("ngay_khoi_hanh") String ngay_khoi_hanh,
							   @RequestParam("ghi_chu") String ghi_chu,
							   @RequestParam("pt_thanh_toan") Integer pt_thanh_toan) {


		ModelAndView mdv = new ModelAndView();

		BookingDTO bookingDTO = new BookingDTO();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date ngay_khoi_hanh_value = null;
		try {
			ngay_khoi_hanh_value = ngay_khoi_hanh != null ? format.parse(ngay_khoi_hanh.split(" ")[0]) : null;
		} catch (ParseException e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/error");
		}

		bookingDTO.setSo_luong_nguoi(so_luong_nguoi);
		bookingDTO.setGhi_chu(ghi_chu);
		bookingDTO.setNgay_khoi_hanh(ngay_khoi_hanh_value);
		bookingDTO.setPt_thanh_toan(pt_thanh_toan);
		bookingDTO.setTour_id(tour_id);
		bookingDTO.setUser_id(SessionUtilities.getUser().getId());


		if(this.bookingService.addNewBooking(bookingDTO)) {
			mdv.setViewName("redirect:/account");
			return mdv;
		}

		mdv.setViewName("redirect:/user/tour");
		return mdv;
	}


	@GetMapping("/error")
	public String error() {

		return "user/error";
	}

	@GetMapping("/user/tour")
	ModelAndView userTour(@RequestParam(value = "ten_tour", required = false) String tenTour) {
		if (!this.userService.checkLogin()) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mdv = new ModelAndView("user/user-booking-list");
		List<BookingDTO> bookingList;

		if (tenTour != null && !tenTour.isEmpty()) {
			bookingList = this.bookingService.findBookingByUserIdAndTourName(SessionUtilities.getUser().getId(), tenTour);
		} else {
			bookingList = this.bookingService.findBookingByUserId(SessionUtilities.getUser().getId());
		}

		mdv.addObject("bookingList", bookingList);
		return mdv;
	}

	@GetMapping("/user/booking/{id}")
	ModelAndView userBookingDetai(@PathVariable Long id) {

		if(!this.userService.checkLogin()){
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mdv = new ModelAndView();

		BookingDTO booking = this.bookingService.getBookingById(id);

		if(booking!=null) {
			mdv.setViewName("user/user-booking");
			mdv.addObject("booking",booking);
			return mdv;
		}

		mdv.setViewName("redirect:/error");
		return mdv;
	}

	@GetMapping("/user/booking/cancel/{id}")
	ModelAndView cancelTour(@PathVariable Long id) {

		if(id==null) {
			return new ModelAndView("redirect:/error");
		}

		String referrer = request.getHeader("Referer");


		log.info("Url trước đó : {}",referrer);

		BookingDTO bookingDTO = this.bookingService.getBookingById(id);

		if(bookingDTO!=null) {

			if(bookingDTO.getTrang_thai()==0 || bookingDTO.getTrang_thai()==1){
				this.bookingService.approveBooking(id,4);
			}

		}else {
			return new ModelAndView("redirect:/error");
		}

		return new ModelAndView("redirect:/user/tour" );
	}

	@GetMapping("/about")
	public String about() {
		return "/user/about";
	}

	@GetMapping("/tin-tuc")
	public String news() {
		return "/user/tin-tuc";
	}

	@GetMapping("/lien-he")
	public String contact() {
		return "/user/contact";
	}

}
