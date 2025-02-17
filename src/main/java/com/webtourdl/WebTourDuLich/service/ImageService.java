package com.webtourdl.WebTourDuLich.service;

import com.webtourdl.WebTourDuLich.entity.Image;

import java.util.List;

public interface ImageService {

	List<Image> findByTourId(Long id);

	public Image addToTour(Long tourId,String url);

	void deleteById(Long id);
}
