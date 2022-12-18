package com.example.day5;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity get()
    {
        ArrayList<Blog> blogs = blogService.getBlogs();
        return ResponseEntity.status(201).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Blog blog , Errors er )
    {
        if(er.hasErrors())
        {
            String msg = er.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        blogService.addBlog(blog);
        return ResponseEntity.status(201).body("Blog Added!!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update( @PathVariable int id, @RequestBody @Valid Blog blog , Errors er )
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(blogService.updateBlog(blog,id))
            return ResponseEntity.status(201).body("Blog updated");
       return ResponseEntity.status(400).body("Blog NOT FOUND!!");
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity delete(@PathVariable int i)
    {
        if(blogService.deleteBlog(i))
            return ResponseEntity.status(201).body("Blog deleted");
        return ResponseEntity.status(400).body("Blog NOT FOUND!!");
    }

}
