package com.codegym.controller.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.entity.employee.Position;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.CustomerTypeService;
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
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("cusType")
    List<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String Home(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("customer", this.customerService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("customer", this.customerService.searchCustomerByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String createCustomer(Model model, @Valid @ModelAttribute Customer customer,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customers", this.customerService.findAll());
            return "customer/create";
        }
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/customer/view/{id}")
    public String readCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message" , "Delete Customer Successful!");
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/customer/edit")
    public String UpdateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer successfully!");
        return "redirect:/customer";
    }
}
