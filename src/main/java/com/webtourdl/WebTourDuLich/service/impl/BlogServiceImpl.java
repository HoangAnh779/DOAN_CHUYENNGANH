package com.webtourdl.WebTourDuLich.service.impl;

import com.webtourdl.WebTourDuLich.entity.Blog;
import com.webtourdl.WebTourDuLich.repository.BlogRepository;
import com.webtourdl.WebTourDuLich.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository BlogRepository;

    @Override
    public Page<Blog> getAllPage(Pageable pageable) {
        Page<Blog> page = this.BlogRepository.findAllPage(pageable);

        return page;
    }

    @Override
    public Blog findOnePage(Long id) {
        return this.BlogRepository.findOnePage(id);
    }

    @Override
    public void deleteOnePage(Long id) {
        this.BlogRepository.deleteById(id);
    }

    @Override
    public Blog createOnePage(Blog newBlog) {
        if(this.BlogRepository.checkExistTieuDe(newBlog.getTieu_de())) {
            return null;
        }
        return this.BlogRepository.save(newBlog);
    }

    @Override
    public Blog updateBlog(Blog updateBlog, Long id) {

        Blog Blog = this.BlogRepository.findOnePage(id);

        if(Blog==null) {
            return null;
        }

        Blog.setHinh_anh(updateBlog.getHinh_anh());
        Blog.setNgay_dang(updateBlog.getNgay_dang());
        Blog.setTom_tat(updateBlog.getTom_tat());
        Blog.setTieu_de(updateBlog.getTieu_de());
        Blog.setNoi_dung(updateBlog.getNoi_dung());


        return this.BlogRepository.save(Blog);
    }

    @Override
    public long countBlogs() {
        return BlogRepository.count();
    }

}
