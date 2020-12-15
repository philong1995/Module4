package com.codegym.controller.employee;

import com.codegym.entity.employee.Division;
import com.codegym.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

    @GetMapping("/division")
    public ModelAndView listDivision(){
        List<Division> divisions = divisionService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/division");
        modelAndView.addObject("division", divisions);
        return modelAndView;
    }
}
