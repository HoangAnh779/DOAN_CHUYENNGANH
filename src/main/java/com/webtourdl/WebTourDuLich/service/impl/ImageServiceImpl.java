package com.webtourdl.WebTourDuLich.service.impl;

import com.webtourdl.WebTourDuLich.entity.Image;
import com.webtourdl.WebTourDuLich.repository.ImageRepository;
import com.webtourdl.WebTourDuLich.repository.TourRepository;
import com.webtourdl.WebTourDuLich.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Image> findByTourId(Long id) {
        return this.imageRepository.findByTourId(id);
    }

    @Override
    public Image addToTour(Long tourId, String url) {
        Image image = new Image();

        if(this.tourRepository.findTourById(tourId)!=null) {
            image.setTour_id(tourId);
            image.setUrl(url);
            return this.imageRepository.save(image);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        this.imageRepository.deleteById(id);
    }
}
