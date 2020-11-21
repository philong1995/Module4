package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Convert;

@Controller
public class ConvertController {

    @Qualifier("convertImpl")
    @Autowired
    private Convert convertService;

    @GetMapping({"/convert"})
    public String convert(@RequestParam String a, Model model) {

        model.addAttribute("money", convertService.convert(Double.parseDouble(a)));

        return "convert";
    }
}
