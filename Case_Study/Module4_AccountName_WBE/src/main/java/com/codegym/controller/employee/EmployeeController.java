package com.codegym.controller.employee;

import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.employee.EducationDegreeService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.employee.PositionService;
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
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;

    @ModelAttribute("position")
    List<Position> positions(){
        return positionService.findAll();
    }

    @ModelAttribute("division")
    List<Division> divisions(){
        return divisionService.findAll();
    }

    @ModelAttribute("education")
    List<EducationDegree> educationDegrees(){
        return educationDegreeService.findAll();
    }

    @GetMapping("/employee")
    public String Home(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("employee", this.employeeService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("employee", this.employeeService.searchEmployeeByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "employee/list";
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String createEmployee(Model model, @Valid @ModelAttribute Employee employee,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", this.employeeService.findAll());
            return "employee/create";
        }
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/view-employee/{id}")
    public String readEmployee(@PathVariable int id, Model model) {
        model.addAttribute("employee",employeeService.findById(id));
        return "/employee/view";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message" , "Delete Employee Successful!");
        return "redirect:/employee";
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
    }

    @PostMapping("/edit-employee")
    public String UpdateEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Update employee successfully!");
        return "redirect:/employee";
    }
}
