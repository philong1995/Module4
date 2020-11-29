package com.codegym.controller;

import com.codegym.entity.MyBlog;
import com.codegym.service.MyBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyBlogController {
    @Autowired
    private MyBlogService myBlogService;

    @GetMapping("/")
    public ModelAndView listBlog(){
        List<MyBlog> myBlog = myBlogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("myBlog", myBlog);
        return modelAndView;
    }

    @GetMapping("/create-my-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("myBlog", new MyBlog());
        return modelAndView;
    }

    @PostMapping("/create-my-blog")
    public ModelAndView saveBlog(@ModelAttribute("myBlog") MyBlog myBlog){
        myBlogService.save(myBlog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("myBlog", new MyBlog());
        modelAndView.addObject("message", "New article created successfully");
        return modelAndView;
    }

    @GetMapping("/view-my-blog/{id}")
    public String readBlock(@PathVariable int id, Model model) {
        model.addAttribute("myBlog",myBlogService.findById(id));
        return "view";
    }

    @GetMapping("/edit-my-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        MyBlog myBlog = myBlogService.findById(id);
        if(myBlog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("myBlog", myBlog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-my-blog")
    public ModelAndView updateBlog(@ModelAttribute("customer") MyBlog myBlog){
        myBlogService.save(myBlog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("myBlog", myBlog);
        modelAndView.addObject("message", "Article updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-my-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        MyBlog myBlog = myBlogService.findById(id);
        if(myBlog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("myBlog", myBlog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-my-blog")
    public String deleteBlog(@ModelAttribute("myBlog") MyBlog myBlog){
        myBlogService.remove(myBlog.getId());
        return "redirect:/";
    }
}
