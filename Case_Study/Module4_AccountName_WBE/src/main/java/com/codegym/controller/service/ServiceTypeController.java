package com.codegym.controller.service;

import com.codegym.entity.employee.Division;
import com.codegym.entity.service.ServiceType;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceTypeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/service-type")
    public ModelAndView serviceType(){
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/service/service_type");
        modelAndView.addObject("serviceType", serviceTypes);
        return modelAndView;
    }
}
