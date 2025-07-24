package com.webtourdl.WebTourDuLich.repository;


import com.webtourdl.WebTourDuLich.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "SELECT t FROM Blog t ORDER BY t.ngay_dang DESC ")
    public Page<Blog> findAllPage(Pageable pageable);

    @Query("SELECT t FROM Blog t WHERE t.id=:id")
    public Blog findOnePage(@Param("id") Long id);

    @Query(value = "SELECT COUNT(*)>0 FROM Blog t WHERE t.tieu_de=:tieu_de")
    public boolean checkExistTieuDe(@Param("tieu_de") String tieu_de);
}
