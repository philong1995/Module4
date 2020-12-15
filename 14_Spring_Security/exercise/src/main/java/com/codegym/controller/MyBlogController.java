package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.entity.MyBlog;
import com.codegym.service.CategoryService;
import com.codegym.service.MyBlogService;
import com.codegym.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class MyBlogController {
    @Autowired
    private MyBlogService myBlogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("my_category")
    public List<Category> provinces(){
        return categoryService.findAll();
    }

    @GetMapping({"","/myBlog"})
    public String Home(Model model,
                       @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("myBlog", this.myBlogService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("myBlog", this.myBlogService.searchPostByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "list";
    }

    @GetMapping("/create-my-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("myBlog", new MyBlog());
        return modelAndView;
    }

    @PostMapping("/create-my-blog")
    public ModelAndView saveBlog(@ModelAttribute("myBlog") MyBlog myBlog){
        myBlogService.save(myBlog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("myBlog", new MyBlog());
        modelAndView.addObject("message", "New article created successfully");
        return modelAndView;
    }

    @GetMapping("/view-my-blog/{id}")
    public String readBlock(@PathVariable int id, Model model) {
        model.addAttribute("myBlog",myBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/edit-my-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        MyBlog myBlog = myBlogService.findById(id);
        if(myBlog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("myBlog", myBlog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-my-blog")
    public ModelAndView updateBlog(@ModelAttribute("myBlog") MyBlog myBlog){
        myBlogService.save(myBlog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("myBlog", myBlog);
        modelAndView.addObject("message", "Article updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-my-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        MyBlog myBlog = myBlogService.findById(id);
        if(myBlog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
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
        return "redirect:myBlog";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }
}
