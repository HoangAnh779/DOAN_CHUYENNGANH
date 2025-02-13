package com.webtourdl.WebTourDuLich.controller.api.admin;

import com.webtourdl.WebTourDuLich.dto.LoginDTO;
import com.webtourdl.WebTourDuLich.dto.ResponseDTO;
import com.webtourdl.WebTourDuLich.service.UserService;
import com.webtourdl.WebTourDuLich.utilities.SessionUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseDTO login(@RequestBody LoginDTO info) {
		if(this.userService.adminLogin(info)) {
			return new ResponseDTO("Thành công", SessionUtilities.getAdmin());
		}
		return new ResponseDTO("Thông tin đăng nhập không hợp lệ", null);
	}

	@GetMapping("/logout")
	public ResponseDTO logout() {
		this.userService.adminLogout();
		return new ResponseDTO("Đăng xuất thành công",null);
	}

}
