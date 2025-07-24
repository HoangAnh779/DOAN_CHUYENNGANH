package com.webtourdl.WebTourDuLich.service;

import com.webtourdl.WebTourDuLich.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    public Page<Blog> getAllPage(Pageable pageable);

    public Blog findOnePage(Long id);

    public  void deleteOnePage(Long id);

    public Blog createOnePage(Blog newBlog);

    public Blog updateBlog(Blog updateBlog,Long id);
    public long countBlogs();
}
