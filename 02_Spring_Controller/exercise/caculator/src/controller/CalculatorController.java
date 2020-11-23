package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalculatorService;

@Controller
public class CalculatorController {

    @GetMapping({"","/calculator"})
    private String calculator(){
        return "calculator";
    }

    @Qualifier("additionImpl")
    @Autowired
    private CalculatorService addition;
    @GetMapping({"/add"})
    public String add2Num(@RequestParam double num1, double num2, Model model) {

        model.addAttribute("resultNumber", addition.operator(num1, num2));

        return "calculator";
    }

    @Qualifier("subtractionImpl")
    @Autowired
    private CalculatorService subtraction;
    @GetMapping("/sub")
    private String sub2Num(@RequestParam double num1, double num2, Model model){

        model.addAttribute("resultNumber",subtraction.operator(num1,num2));

        return "calculator";
    }

    @Qualifier("multiplicationImpl")
    @Autowired
    private CalculatorService multiplication;
    @GetMapping("/mul")
    private String mul2Num(@RequestParam double num1, double num2, Model model){

        model.addAttribute("resultNumber",multiplication.operator(num1,num2));

        return "calculator";
    }

    @Qualifier("divisionImpl")
    @Autowired
    private CalculatorService division;
    @GetMapping("/div")
    private String div2Num(@RequestParam double num1, double num2, Model model){
        if(num2==0){
            String result = "Cannot perform calculation";

            model.addAttribute("resultNumber",result);
        }else{

            model.addAttribute("resultNumber",division.operator(num1,num2));
        }
        return "calculator";
    }
}
