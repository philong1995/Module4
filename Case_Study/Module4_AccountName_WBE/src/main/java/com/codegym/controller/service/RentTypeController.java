package com.codegym.controller.service;

import com.codegym.entity.service.RentType;
import com.codegym.entity.service.ServiceType;
import com.codegym.service.service.RentTypeService;
import com.codegym.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RentTypeController {
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/rent-type")
    public ModelAndView rentType(){
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/service/rent_type");
        modelAndView.addObject("rentType", rentTypes);
        return modelAndView;
    }
}
