package com.webtourdl.WebTourDuLich.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
@Table(name = "tin_tuc")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tieu_de;

    private String tom_tat;

    private String noi_dung;

    private String hinh_anh;

    private Date ngay_dang;
}
