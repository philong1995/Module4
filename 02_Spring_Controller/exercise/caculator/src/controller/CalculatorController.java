package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalculatorService;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping({"","/"})
    public String calculator(){
        return "calculator";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculate, Model model){
        double resultNumber = calculatorService.operator(num1,num2,calculate);
        model.addAttribute("resultNumber",resultNumber);
        return "calculator";
    }
}
