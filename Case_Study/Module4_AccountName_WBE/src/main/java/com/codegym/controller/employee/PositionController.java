package com.codegym.controller.employee;

import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.Position;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/position")
    public ModelAndView listPosition(){
        List<Position> positions = positionService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/position");
        modelAndView.addObject("position", positions);
        return modelAndView;
    }
}
