package com.cralor.service;

import com.cralor.entity.Blog;

import java.util.List;

/**
 * Created by cc.
 * 2018/7/31 13:42
 **/
public interface IBlogService {
    /**
     * 获取所有Blog
     * @return
     */
    List<Blog> getBlogs();

    /**
     * 根据ID获取Blog
     * @param id
     */
    void deleteBlog(long id);
}
