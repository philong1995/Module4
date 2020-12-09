package com.codegym.controller;

import com.codegym.entity.Province;
import com.codegym.service.ProvinceService;
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
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/provinces")
    public String provinceList(Model model,
                           @PageableDefault(size = 5) Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("provinces", this.provinceService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("provinces", this.provinceService.searchProvince(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "province/list";
    }

    @GetMapping("/create-province")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public String CreateProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        this.provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create province successfully!");
        return "redirect:/provinces";
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Province province = provinceService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("Error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteCard(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.delete(province.getIdProvince());
        redirectAttributes.addFlashAttribute("message", "Delete province done!");
        return "redirect:/provinces";
    }

}
