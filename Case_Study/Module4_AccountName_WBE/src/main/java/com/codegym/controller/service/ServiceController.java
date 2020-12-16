package com.codegym.controller.service;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.service.RentType;
import com.codegym.entity.service.Service;
import com.codegym.entity.service.ServiceType;
import com.codegym.service.service.RentTypeService;
import com.codegym.service.service.ServiceService;
import com.codegym.service.service.ServiceTypeService;
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
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @ModelAttribute("serviceType")
    List<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentType")
    List<RentType> rentTypes(){
        return rentTypeService.findAll();
    }

    @GetMapping("/service")
    public String Home(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("service", this.serviceService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("service", this.serviceService.searchServiceByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "service/list";
    }

    @GetMapping("/service/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/service/create")
    public String createService(Model model, @Valid @ModelAttribute Service service,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("services", this.serviceService.findAll());
            return "service/create";
        }
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/service";
    }

    @GetMapping("/service/view/{id}")
    public String readService(@PathVariable int id, Model model) {
        model.addAttribute("service",serviceService.findById(id));
        return "/service/view";
    }

    @GetMapping("/service/delete")
    public String deleteService(@RequestParam int id, RedirectAttributes redirectAttributes) {
        serviceService.delete(id);
        redirectAttributes.addFlashAttribute("message" , "Delete Service Successful!");
        return "redirect:/service";
    }

    @GetMapping("/service/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Service service = serviceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/service/edit");
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping("/service/edit")
    public String UpdateService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Update Service successfully!");
        return "redirect:/service";
    }
}
