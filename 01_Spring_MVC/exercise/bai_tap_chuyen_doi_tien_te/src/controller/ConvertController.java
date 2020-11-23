package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;

@Controller
public class ConvertController {

    @Qualifier("convertImpl")
    @Autowired
    private ConvertService convertService;

    @GetMapping({"/convert"})
    public String convert(@RequestParam double a, Model model) {

        model.addAttribute("money", convertService.convert(a));

        return "convert";
    }
}
