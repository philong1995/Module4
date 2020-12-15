package com.codegym.controller.employee;

import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EducationDegreeController {
    @Autowired
    private EducationDegreeService degreeService;

    @GetMapping("/education")
    public ModelAndView listDivision(){
        List<EducationDegree> educationDegrees = degreeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/education");
        modelAndView.addObject("education", educationDegrees);
        return modelAndView;
    }
}
