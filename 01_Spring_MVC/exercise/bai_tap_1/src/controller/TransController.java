package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TranslateService;

@Controller
public class TransController {

    @Qualifier("translateImpl")
    @Autowired
    private TranslateService transService;

    @GetMapping ({"/trans"})
    public String translate(@RequestParam String word, Model model) {
        String trans = transService.trans(word);
        model.addAttribute("transWord", trans);

        return "trans";
    }


}
