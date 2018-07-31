package com.cralor.controller;

import com.cralor.entity.Blog;
import com.cralor.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by cc.
 * 2018/7/31 13:50
 **/
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping
    public ModelAndView list(Model model) {

        List<Blog> list =blogService.getBlogs();
        model.addAttribute("blogsList", list);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    /**
     * 需要拥有“ADMIN”角色权限才可以访问
     * @param id 要删除的Blog的id
     * @param model 返回的视图模型
     * @return 返回页面
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        blogService.deleteBlog(id);
        model.addAttribute("blogsList", blogService.getBlogs());
        return new ModelAndView("blogs/list", "blogModel", model);
    }
}
