package com.webtourdl.WebTourDuLich.controller.api.admin;


import com.webtourdl.WebTourDuLich.dto.ResponseDTO;
import com.webtourdl.WebTourDuLich.entity.Blog;
import com.webtourdl.WebTourDuLich.service.BlogService;
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
public class BlogController {

    @Autowired
    private BlogService BlogService;

    // Lấy tất cả tin tức phân trang
    @GetMapping("/getAllPage")
    public ResponseDTO getAllPage(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "pageIndex", defaultValue = "0") Integer pageIndex) {
        Page<Blog> page = this.BlogService.getAllPage(PageRequest.of(pageIndex, pageSize));
        return new ResponseDTO("Thành Công", page.getContent());
    }

    // Lấy chi tiết tin tức theo ID
    @GetMapping("/{id}")
    public ResponseDTO getOnePage(@PathVariable("id") Long id) {
        return new ResponseDTO("Thành công", this.BlogService.findOnePage(id));
    }

    // Thêm tin tức mới
    @PostMapping("/add")
    public ResponseDTO addNewBlog(@RequestBody Blog Blog) {
        Blog createdBlog = this.BlogService.createOnePage(Blog);
        return new ResponseDTO("Thành công", createdBlog);
    }

    // Thêm ảnh tin tức
    @PostMapping("/add/image/{id}")
    public ResponseDTO uploadImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) {
        String uploadDir = "/upload";
        try {
            String fileName = image.getOriginalFilename();
            FileUploadUtil.saveFile(uploadDir, fileName, image);

            // Cập nhật đường dẫn ảnh
            Blog Blog = this.BlogService.findOnePage(id);
            Blog.setHinh_anh(fileName);
            this.BlogService.updateBlog(Blog, id);

            return new ResponseDTO("Upload thành công", null);
        } catch (IOException e) {
            log.error("Lỗi upload file: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }

    // Cập nhật tin tức
    @PutMapping("/update/{id}")
    public ResponseDTO updateOneBlog(@PathVariable("id") Long id, @RequestBody Blog Blog) {
        Blog updatedBlog = this.BlogService.updateBlog(Blog, id);
        return new ResponseDTO("Cập nhật thành công", updatedBlog);
    }

    // Cập nhật ảnh tin tức
    @PutMapping("/update/image/{id}")
    public ResponseDTO updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) {
        String uploadDir = "/upload";
        try {
            String fileName = image.getOriginalFilename();
            FileUploadUtil.saveFile(uploadDir, fileName, image);

            Blog Blog = this.BlogService.findOnePage(id);
            Blog.setHinh_anh(fileName);
            this.BlogService.updateBlog(Blog, id);

            return new ResponseDTO("Cập nhật ảnh thành công", null);
        } catch (IOException e) {
            log.error("Lỗi upload file: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }

    // Xóa tin tức
    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteOneBlog(@PathVariable("id") Long id) {
        try {
            this.BlogService.deleteOnePage(id);
            return new ResponseDTO("Xóa thành công", null);
        } catch (Exception e) {
            log.error("Lỗi xóa tin tức: {}", e.getMessage());
            return new ResponseDTO("Thất bại", null);
        }
    }
    // Đếm tin tức
    @GetMapping("/count")
    public ResponseDTO getBlogCount() {
        long BlogCount = BlogService.countBlogs();
        Map<String, Long> response = new HashMap<>();
        response.put("count", BlogCount);
        return new ResponseDTO("Thành công", response);
    }
}
