package com.webtourdl.WebTourDuLich.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
@Table(name = "tour")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ten_tour;
	
	private String gioi_thieu_tour;
	
	private Integer so_ngay;

	@Column(columnDefinition = "NVARCHAR(1000)")
	private String noi_dung_tour;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngay_khoi_hanh;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngay_ket_thuc;
	
	private String diem_den;
	
	private Integer loai_tour;
	
	private String anh_tour;
	
	private String diem_khoi_hanh;
	
	private Integer trang_thai;
	
	private Long gia_tour;

	@Column(nullable = true)
	private Integer giam_gia;

	@Column(length = 50, nullable = true)
	private String ma_giam_gia;

}
