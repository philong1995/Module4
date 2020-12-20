package com.codegym.controller.contract;

import com.codegym.entity.contract.AttachService;
import com.codegym.entity.employee.Division;
import com.codegym.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AttachServiceController {
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping("/attach-service")
    public ModelAndView listAttachService() {
        List<AttachService> attachServices = attachServiceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/attach_service");
        modelAndView.addObject("attachService", attachServices);
        return modelAndView;
    }
}
