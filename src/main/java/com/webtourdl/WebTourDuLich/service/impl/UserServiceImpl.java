package com.webtourdl.WebTourDuLich.service.impl;

import com.webtourdl.WebTourDuLich.dto.*;
import com.webtourdl.WebTourDuLich.entity.User;
import com.webtourdl.WebTourDuLich.enumtype.AuthenticationProvider;
import com.webtourdl.WebTourDuLich.oauth.CustomOAuth2User;
import com.webtourdl.WebTourDuLich.repository.BookingRepository;
import com.webtourdl.WebTourDuLich.repository.UserRepository;
import com.webtourdl.WebTourDuLich.service.UserService;
import com.webtourdl.WebTourDuLich.utilities.ConvertUserToDto;
import com.webtourdl.WebTourDuLich.utilities.SessionUtilities;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Page<UserDTO> findAllUser(String sdt,String email,String ho_ten,Pageable pageable) {

		Page<User> page = userRepository.findAll(sdt,email,ho_ten,pageable);

		Page<UserDTO> pageUserDTO = new PageImpl<>(
			page.getContent().stream().map(user ->  {

				UserDTO userDTO = ConvertUserToDto.convertUsertoDto(user);
				return userDTO;
			}).collect(Collectors.toList()),
				page.getPageable(),
				page.getTotalElements()
		);

		return pageUserDTO;
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			return user;
		}
		return null;
	}
	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.getUserByEmail(email);
		if(user!=null) {
			return user;
		}
		return null;
	}

	@Override
	public boolean saveUser(User user) {
		if(this.userRepository.save(user)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(UpdateUserDTO updateUserDTO) {
		if(SessionUtilities.getUser()!=null) {
			Long user_id = SessionUtilities.getUser().getId();

			User user = this.userRepository.findById(user_id).get();

			user.setSdt(updateUserDTO.getSdt());
			user.setUsername(updateUserDTO.getUsername());
			user.setEmail(updateUserDTO.getEmail());
			user.setDia_chi(updateUserDTO.getDia_chi());
			user.setHo_ten(updateUserDTO.getHo_ten());
			user.setGioi_tinh(updateUserDTO.getGioi_tinh());

			this.userRepository.save(user);

			SessionUtilities.setUser(ConvertUserToDto.convertUsertoDto(user));

			return true;

		}

		return false;
	}

	@Override
	public boolean deleteUserById(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			if(this.bookingRepository.findBookingByUserId(id)==null || this.bookingRepository.findBookingByUserId(id).size()==0) {
				this.userRepository.deleteById(id);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean login(LoginDTO user) {

		User userCheck = this.findUserByUsername(user.getUsername());

		if(userCheck==null) {
			return false;
		}

		log.info("userCheck:{}",userCheck.getUsername());

		if(BCrypt.checkpw(user.getPassword(), userCheck.getPassword())) {
			SessionUtilities.setUsername(userCheck.getUsername());
			SessionUtilities.setUser(ConvertUserToDto.convertUsertoDto(userCheck));

			log.info("userCheck:{}",SessionUtilities.getUsername());
			return true;
		}


		return false;
	}

	@Override
	public boolean register(RegisterDTO newUser) {

		User userCheckByUserName = this.findUserByUsername(newUser.getUsername());
		User userCheckByEmail = this.userRepository.getUserByEmail(newUser.getEmail());
		if(userCheckByUserName!=null || userCheckByEmail!=null) {
			return false;
		}

		User user= new User();
		user.setUsername(newUser.getUsername());
		user.setHo_ten(newUser.getHo_ten());
		user.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt(10)));
		user.setEmail(newUser.getEmail());
		user.setGioi_tinh(newUser.getGioi_tinh());
		user.setRole(1);
		user.setDia_chi(newUser.getDia_chi());
		user.setSdt(newUser.getSdt());


		return this.saveUser(user);
	}

	@Override
	public boolean checkLogin() {
		return SessionUtilities.getUsername()!=null;
	}

	@Override
	public boolean changePassword(ChangePasswordDTO changePasswordDTO) {
		if(SessionUtilities.getUser()!=null) {
			Long user_id = SessionUtilities.getUser().getId();

			User user = this.userRepository.findById(user_id).get();

			if(BCrypt.checkpw(changePasswordDTO.getOldPassword(),user.getPassword()) && changePasswordDTO.getNewPassword()!=null) {
				user.setPassword(BCrypt.hashpw(changePasswordDTO.getNewPassword(), BCrypt.gensalt(10)));
				this.userRepository.save(user);
				return true;
			}
			return false;

		}
		return false;
	}

	@Override
	public boolean forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		User user = this.userRepository.getUserByEmail(forgotPasswordDTO.getYouremail());

		if (user != null && forgotPasswordDTO.getNewPassword() != null) {
			user.setPassword(BCrypt.hashpw(forgotPasswordDTO.getNewPassword(), BCrypt.gensalt(10)));
			this.userRepository.save(user);
			return true;
		}

		return false;
	}

	@Override
	public boolean updateUserByAdmin(UpdateUserDTO updateUserDTO,Long id) {

		User user = this.userRepository.findById(id).get();
		if(user!=null) {
			user.setSdt(updateUserDTO.getSdt());
			user.setUsername(updateUserDTO.getUsername());
			user.setEmail(updateUserDTO.getEmail());
			user.setDia_chi(updateUserDTO.getDia_chi());
			user.setHo_ten(updateUserDTO.getHo_ten());
			user.setGioi_tinh(updateUserDTO.getGioi_tinh());

			this.userRepository.save(user);

			return true;
		}

		return false;
	}

	@Override
	public boolean adminLogin(LoginDTO user) {
		User userCheck = this.findUserByUsername(user.getUsername());

		if(userCheck==null) {
			return false;
		}

		log.info("userCheck:{}",userCheck.getUsername());

		if(BCrypt.checkpw(user.getPassword(), userCheck.getPassword()) && userCheck.getRole()==0) {

			SessionUtilities.setAdmin(ConvertUserToDto.convertUsertoDto(userCheck));

			log.info("userCheck:{}",SessionUtilities.getAdmin().getUsername());

			return true;
		}


		return false;
	}

	@Override
	public boolean checkAdminLogin() {
		return SessionUtilities.getAdmin()!=null;
	}

	@Override
	public void adminLogout() {
		SessionUtilities.setAdmin(null);
	}

	@Override
	public boolean resetPass(Long id) {
		User user = this.userRepository.findById(id).get();

		user.setPassword(BCrypt.hashpw("Aa@123", BCrypt.gensalt(10)));

		if(this.userRepository.save(user)!=null) {
			return true;
		}

		return false;
	}

	@Override
	public long countUsers() {
		return userRepository.count();
	}

	public void createNewCustomerAfterOAuthLoginSuccess(String email , String name, AuthenticationProvider provider) {
		User user = new User();
		user.setEmail(email);
		user.setHo_ten(name);
		// Tạo username từ email hoặc tên
		String username;
		if (email != null && !email.isEmpty()) {
			username = email.split("@")[0]; // Lấy phần trước '@' của email
		} else if (name != null && !name.isEmpty()) {
			username = name; // Nếu không có email, dùng tên làm username
		} else {
			throw new IllegalArgumentException("Email hoặc tên không hợp lệ!"); // Kiểm tra đầu vào hợp lệ
		}
		user.setUsername(username);
		user.setRole(1);
		user.setAuthProvider(provider);
		user.setPassword(BCrypt.hashpw("Aa123", BCrypt.gensalt(10)));
		userRepository.save(user);

	}

	public void updateUserCustomerAfterOAuthLoginSuccess(User user, String name, AuthenticationProvider provider) {
		user.setHo_ten(name);
		user.setAuthProvider(provider);
		user.setPassword(BCrypt.hashpw("Aa123", BCrypt.gensalt(10)));
		user.setRole(1);
		userRepository.save(user);
	}
}
