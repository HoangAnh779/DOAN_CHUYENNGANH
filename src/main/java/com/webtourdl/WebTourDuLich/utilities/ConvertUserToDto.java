package com.webtourdl.WebTourDuLich.utilities;

import com.webtourdl.WebTourDuLich.dto.UserDTO;
import com.webtourdl.WebTourDuLich.entity.User;

public class ConvertUserToDto {
	
	public static UserDTO convertUsertoDto(User user) {
		return new UserDTO(user.getId(),user.getUsername(), user.getHo_ten(), user.getSdt(), user.getGioi_tinh(), user.getEmail(),
				user.getDia_chi(), user.getRole() );
	}
	
}
