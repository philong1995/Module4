package com.codegym.controller.customer;

import com.codegym.entity.customer.CustomerType;
import com.codegym.entity.employee.Division;
import com.codegym.service.customer.CustomerTypeService;
import com.codegym.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/customer-type")
    public ModelAndView listDivision(){
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/customer_type");
        modelAndView.addObject("customerType", customerTypes);
        return modelAndView;
    }
}
