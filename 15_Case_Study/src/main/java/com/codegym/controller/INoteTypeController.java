package com.codegym.controller;

import com.codegym.entity.INoteType;
import com.codegym.service.INoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class INoteTypeController {
    @Autowired
    private INoteTypeService iNoteTypeService;

    @GetMapping("/i-note-type")
    public ModelAndView listDivision(){
        List<INoteType> iNoteTypes = iNoteTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/i_note_type");
        modelAndView.addObject("iNoteType", iNoteTypes);
        return modelAndView;
    }
}
