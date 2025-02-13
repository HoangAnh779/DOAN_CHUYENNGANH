package com.webtourdl.WebTourDuLich.controller.api.admin;


import com.webtourdl.WebTourDuLich.dto.ResponseDTO;
import com.webtourdl.WebTourDuLich.entity.TinTuc;
import com.webtourdl.WebTourDuLich.service.TinTucService;
import com.webtourdl.WebTourDuLich.utilities.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/tin_tuc")
public class TinTucController {

    @Autowired
    private TinTucService tinTucService;

    // Lấy tất cả tin tức phân trang
    @GetMapping("/getAllPage")
    public ResponseDTO getAllPage(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "pageIndex", defaultValue = "0") Integer pageIndex) {
        Page<TinTuc> page = this.tinTucService.getAllPage(PageRequest.of(pageIndex, pageSize));
        return new ResponseDTO("Thành Công", page.getContent());
    }

    // Lấy chi tiết tin tức theo ID
    @GetMapping("/{id}")
    public ResponseDTO getOnePage(@PathVariable("id") Long id) {
        return new ResponseDTO("Thành công", this.tinTucService.findOnePage(id));
    }

    // Thêm tin tức mới
    @PostMapping("/add")
    public ResponseDTO addNewTinTuc(@RequestBody TinTuc tinTuc) {
        TinTuc createdTinTuc = this.tinTucService.createOnePage(tinTuc);
        return new ResponseDTO("Thành công", createdTinTuc);
    }

    // Thêm ảnh tin tức
    @PostMapping("/add/image/{id}")
    public ResponseDTO uploadImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) {
        String uploadDir = "/upload";
        try {
            String fileName = image.getOriginalFilename();
            FileUploadUtil.saveFile(uploadDir, fileName, image);

            // Cập nhật đường dẫn ảnh
            TinTuc tinTuc = this.tinTucService.findOnePage(id);
            tinTuc.setHinh_anh(fileName);
            this.tinTucService.updateTinTuc(tinTuc, id);

            return new ResponseDTO("Upload thành công", null);
        } catch (IOException e) {
            log.error("Lỗi upload file: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }

    // Cập nhật tin tức
    @PutMapping("/update/{id}")
    public ResponseDTO updateOneTinTuc(@PathVariable("id") Long id, @RequestBody TinTuc tinTuc) {
        TinTuc updatedTinTuc = this.tinTucService.updateTinTuc(tinTuc, id);
        return new ResponseDTO("Cập nhật thành công", updatedTinTuc);
    }

    // Cập nhật ảnh tin tức
    @PutMapping("/update/image/{id}")
    public ResponseDTO updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) {
        String uploadDir = "/upload";
        try {
            String fileName = image.getOriginalFilename();
            FileUploadUtil.saveFile(uploadDir, fileName, image);

            TinTuc tinTuc = this.tinTucService.findOnePage(id);
            tinTuc.setHinh_anh(fileName);
            this.tinTucService.updateTinTuc(tinTuc, id);

            return new ResponseDTO("Cập nhật ảnh thành công", null);
        } catch (IOException e) {
            log.error("Lỗi upload file: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }

    // Xóa tin tức
    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteOneTinTuc(@PathVariable("id") Long id) {
        try {
            this.tinTucService.deleteOnePage(id);
            return new ResponseDTO("Xóa thành công", null);
        } catch (Exception e) {
            log.error("Lỗi xóa tin tức: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }
    // Đếm tin tức
    @GetMapping("/count")
    public ResponseDTO getTinTucCount() {
        long tinTucCount = tinTucService.countBlogs();
        Map<String, Long> response = new HashMap<>();
        response.put("count", tinTucCount);
        return new ResponseDTO("Thành công", response);
    }
}
