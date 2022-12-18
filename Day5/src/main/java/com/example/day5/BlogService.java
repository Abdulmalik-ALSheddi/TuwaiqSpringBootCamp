package com.example.day5;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class BlogService {

    ArrayList<Blog> blogs = new ArrayList<>();

    public ArrayList<Blog> getBlogs() {
        return blogs;
    }


    public void addBlog(Blog blog) {
        blogs.add(blog);
    }

    public boolean updateBlog(Blog blog, int id) {
        for (int i = 0; i < blogs.size() ; i++) {
            if(blogs.get(i).getId() == id)
            {
                blogs.set(i,blog);
                return true;
            }
        }
      return false;
    }

    public boolean deleteBlog(int id) {
        for (int i = 0; i < blogs.size() ; i++) {
            if(blogs.get(i).getId() == id)
            {
                blogs.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean search(int id)
    {
        for (int i = 0; i < blogs.size() ; i++) {
            if(blogs.get(i).getId() == id)
                return true;
        }
        return false;
    }
}
