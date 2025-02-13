package com.webtourdl.WebTourDuLich.repository;

import com.webtourdl.WebTourDuLich.dto.TourStartDTO;
import com.webtourdl.WebTourDuLich.entity.TourStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourStartRepository extends JpaRepository<TourStart, Long>{
	
	@Query("SELECT new com.webtourdl.WebTourDuLich.dto.TourStartDTO(d.id,d.ngay_khoi_hanh) FROM TourStart d WHERE d.tour_id = :tour_id")
	List<TourStartDTO> getDateStartByTourId(@Param("tour_id") Long tour_id);
}
