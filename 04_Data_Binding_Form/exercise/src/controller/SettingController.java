package controller;

import model.SettingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.SettingEmailService;

@Controller
public class SettingController {

    @Autowired
    private SettingEmailService emailService;

    @GetMapping({"", "/home"})
    public String Setting(Model model) {
        model.addAttribute("setting", new SettingEmail());
        model.addAttribute("languageList" , emailService.languageList());
        model.addAttribute("pageList", emailService.pageList());
        return "index";
    }

    @PostMapping("/setting")
    public String save(@ModelAttribute SettingEmail setting,Model model){
        model.addAttribute("setting",setting);
        return "home";
    }
}
