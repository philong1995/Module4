package com.codegym.controller;

import com.codegym.entity.INote;
import com.codegym.entity.INoteType;
import com.codegym.service.INoteService;
import com.codegym.service.INoteTypeService;
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
public class INoteController {
    @Autowired
    INoteService iNoteService;

    @Autowired
    INoteTypeService iNoteTypeService;

    @ModelAttribute("type")
    List<INoteType> iNoteTypes(){
        return iNoteTypeService.findAll();
    }

    @GetMapping({"/","","/note"})
    public String Home(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("note", this.iNoteService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("note", this.iNoteService.search(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "/i_note";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("note", new INote());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNote(Model model, @Valid @ModelAttribute INote iNote,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("notes", this.iNoteService.findAll());
            return "/create";
        }
        this.iNoteService.save(iNote);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:";
    }

    @GetMapping("/view/{id}")
    public String readNote(@PathVariable int id, Model model) {
        model.addAttribute("note",iNoteService.findById(id));
        return "/view";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iNoteService.delete(id);
        redirectAttributes.addFlashAttribute("message" , "Delete Note Successful!");
        return "redirect:/note";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        INote iNote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("note", iNote);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String UpdateCustomer(@ModelAttribute INote iNote, RedirectAttributes redirectAttributes) {
        this.iNoteService.save(iNote);
        redirectAttributes.addFlashAttribute("message", "Update Note successfully!");
        return "redirect:/note";
    }
}
