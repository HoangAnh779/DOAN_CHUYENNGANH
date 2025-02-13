package com.webtourdl.WebTourDuLich.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.webtourdl.WebTourDuLich.enumtype.AuthenticationProvider;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String ho_ten;

	@JsonIgnore
	private String password;

	private String gioi_tinh;

	private String sdt;

	private String email;

	private String dia_chi;

	private Integer role;

	@Enumerated(EnumType.STRING)
	@Column(name = "auth_provider")
	private AuthenticationProvider authProvider;
}
