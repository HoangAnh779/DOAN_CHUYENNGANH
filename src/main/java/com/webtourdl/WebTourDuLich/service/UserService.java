package com.webtourdl.WebTourDuLich.service;

import com.webtourdl.WebTourDuLich.dto.*;
import com.webtourdl.WebTourDuLich.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	public Page<UserDTO> findAllUser(String sdt,String email,String ho_ten, Pageable pageable);
	public User findUserById(Long id);
	public User findUserByUsername(String username);
	public User getUserByEmail(String email);
	public boolean saveUser(User user);
	public boolean login(LoginDTO user);
	public boolean register(RegisterDTO user);
	public boolean updateUser(UpdateUserDTO updateUserDTO);
	public boolean deleteUserById(Long id);
	public boolean checkLogin();
	public boolean changePassword(ChangePasswordDTO changePasswordDTO);
	public boolean forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
	public boolean updateUserByAdmin(UpdateUserDTO updateUserDTO,Long id);
	public boolean adminLogin(LoginDTO user);
	public boolean checkAdminLogin();
	public void adminLogout();
	public boolean resetPass(Long id);
	public long countUsers();
}
