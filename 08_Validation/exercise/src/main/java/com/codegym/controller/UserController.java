package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping({"","/user"})
    public String home(Model model,
                        @PageableDefault(size = 3) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("user", this.userService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("user", this.userService.searchUserByFirstName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "list";
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public String createStudent(Model model, @Valid @ModelAttribute User user,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("users", this.userService.findAll());
            return "create";
        }

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");

        return "redirect:/user";
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-user")
    public ModelAndView updateBlog(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.delete(user.getId());
        return "redirect: ";
    }
}
