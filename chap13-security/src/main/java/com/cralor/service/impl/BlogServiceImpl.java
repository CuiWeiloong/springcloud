package com.cralor.service.impl;

import com.cralor.entity.Blog;
import com.cralor.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fangzhipeng on 2017/5/15.
 */
@Service
public class BlogServiceImpl implements IBlogService {

    private List<Blog> list=new ArrayList<>();

    public BlogServiceImpl(){
        list.add(new Blog(1L, " spring in action", "good!"));
        list.add(new Blog(2L,"spring boot in action", "nice!"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(long id) {
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            Blog blog= (Blog) iter.next();
            if (blog.getId()==id){
                iter.remove();
            }
        }
    }
}
