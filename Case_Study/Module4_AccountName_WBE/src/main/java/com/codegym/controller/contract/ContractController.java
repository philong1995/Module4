package com.codegym.controller.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.Service;
import com.codegym.service.contract.ContractService;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.CustomerTypeService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    ContractService contractService;

    @ModelAttribute("employee")
    List<Employee> employees(){
        return employeeService.findAll();
    }

    @ModelAttribute("customer")
    List<Customer> customers(){
        return customerService.findAll();
    }

    @ModelAttribute("service")
    List<Service> services(){
        return serviceService.findAll();
    }

    @GetMapping("/contract")
    public ModelAndView listContract(){
        List<Contract> contracts = contractService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/contract");
        modelAndView.addObject("contract", contracts);
        return modelAndView;
    }

    @GetMapping("/contract/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public String createContract(Model model, @Valid @ModelAttribute Contract contract,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new Contract().validate(contract,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("contracts", this.contractService.findAll());
            return "contract/create";
        }
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract";
    }
}
