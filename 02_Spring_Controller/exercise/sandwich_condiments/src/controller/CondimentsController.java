package controller;

import model.SandwichCondiments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CondimentsService;

@Controller
public class CondimentsController {
    @Autowired
    private CondimentsService condimentsService;

    @GetMapping({"","/list"})
    public String list(Model model){
        model.addAttribute("condimentsList", condimentsService.listCondiments());
        return "list";
    }

    @GetMapping("/save")
    public String save (@RequestParam String name,
                        @RequestParam("condiments") String[] condiments, Model model)
    {
        condimentsService.addNewCondiments(new SandwichCondiments(name, condiments));
        model.addAttribute("condimentsList", condimentsService.listCondiments());
        return "list";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }
}
