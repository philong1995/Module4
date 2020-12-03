package com.codegym.controller;

import com.codegym.entity.LibraryCard;
import com.codegym.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class LibraryCardController {
    @Autowired
    LibraryCardService libraryCardService;

    @GetMapping("/card")
    public String cardList(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("card", this.libraryCardService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("card", this.libraryCardService.searchCardByNameStudent(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "card/list";
    }

    @GetMapping("/create-new-card")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("card/create");
        modelAndView.addObject("card", new LibraryCard());
        return modelAndView;
    }

    @PostMapping("/create-new-card")
    public String CreateNewCard(@ModelAttribute LibraryCard libraryCard, RedirectAttributes redirectAttributes) {
        this.libraryCardService.save(libraryCard);
        redirectAttributes.addFlashAttribute("message", "Create new card successfully!");
        return "redirect:/card";
    }

    @GetMapping("/delete-card/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        LibraryCard libraryCard = libraryCardService.findById(id);
        if(libraryCard != null) {
            ModelAndView modelAndView = new ModelAndView("card/delete");
            modelAndView.addObject("card", libraryCard);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("Error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-card")
    public String deleteCard(@ModelAttribute("card") LibraryCard libraryCard){
        libraryCardService.delete(libraryCard.getId());
        return "redirect:/card";
    }
}
