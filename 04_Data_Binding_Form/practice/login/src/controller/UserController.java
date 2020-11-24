package controller;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @GetMapping({"","/login"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("login", "login", new Login());
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "create";
    }

    @PostMapping("/create-user")
    public String create(Model model,@ModelAttribute User user){
        userService.create(user);
        model.addAttribute("user",user);
        return "user";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserService.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
