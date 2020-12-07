package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.entity.MyBlog;
import com.codegym.service.CategoryService;
import com.codegym.service.MyBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apiBlog")
public class BlogRestController {
    @Autowired
    private MyBlogService myblogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list-blog")
    public ResponseEntity<List<MyBlog>> getAllBlog(){
        List<MyBlog> listBlog = myblogService.findAll();
        if(listBlog.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(listBlog,HttpStatus.ACCEPTED);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<MyBlog> getDetail(@PathVariable Integer id){
        MyBlog myBlog = myblogService.findById(id);
        return new ResponseEntity<>(myBlog,HttpStatus.ACCEPTED);
    }
    @GetMapping("category")
    public  ResponseEntity<List<Category>> getAllCategory(){
        List<Category> listCategory = categoryService.findAll();
        if(listCategory.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(listCategory,HttpStatus.OK);
    }
}
