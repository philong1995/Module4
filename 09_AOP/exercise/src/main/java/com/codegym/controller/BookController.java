package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.service.BookService;
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
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping({"/","/book",""})
    public String home(Model model,
                       @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("book", this.bookService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("book", this.bookService.searchBookByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "Home";
    }

    @GetMapping("/add-new-book")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("book/Add");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/add-new-book")
    public String AddNewBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        this.bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Add new book successfully!");
        return "redirect:";
    }

    @GetMapping("/borrow")
    public String showBorrow(@RequestParam int id, Model model) throws Exception {
        int amount = this.bookService.getAmount(id);
        if (amount == 0 ) {
            throw new Exception();
        }

        model.addAttribute("book", this.bookService.findById(id));
        return "Borrow";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam String id_card, @RequestParam int id_book, RedirectAttributes redirectAttributes) throws Exception {
        this.bookService.borrowBook(id_card, id_book);
        redirectAttributes.addFlashAttribute("message", "Borrowed successfully");
        return "redirect:";
    }

    @GetMapping("/pay")
    public String showPay(@RequestParam int id, Model model){
        model.addAttribute("book", this.bookService.findById(id));
        return "Pay";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam int id_card, @RequestParam int id_book, RedirectAttributes redirectAttributes) throws Exception {
        this.bookService.payBook(id_card, id_book);
        redirectAttributes.addFlashAttribute("message", "Pay successful");
        return "redirect:";
    }

    @ExceptionHandler(Exception.class)
    public String catchException() {
        return "error";
    }
}
