package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.ClassRoomService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    // private StudentService studentService = new StudentServiceImpl();

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping({"", "/list"})
    public String goStudentList(Model model,
                                @PageableDefault(size = 3) Pageable pageable,
                                @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("listStudent", this.studentService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listStudent", this.studentService.searchStudentByName(keywordAfterCheck, pageable));
        }

        model.addAttribute("keywordAfterCheck", keywordAfterCheck);

        return "list_student";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String goDetailStudentPathVariable(@PathVariable Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("studentObj", new Student());
        model.addAttribute("listClassRoom", this.classRoomService.findAll());
        return "create_student";
    }

    @PostMapping("/create")
    public String createStudent(Model model, @Valid @ModelAttribute(name = "studentObj") Student student,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("listClassRoom", this.classRoomService.findAll());
            return "create_student";
        }

        this.studentService.save(student);
        redirectAttributes.addFlashAttribute("messageSuccess", "Register successfully!");

        return "redirect:/student/list";
    }
}
