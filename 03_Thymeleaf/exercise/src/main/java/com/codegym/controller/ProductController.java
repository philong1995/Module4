package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService = new ProductImpl();

    @GetMapping(value = "/",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String index(Model model) {
        List productList = productService.findAll();
        model.addAttribute("product", productList);
        return "home";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }
    //      Edit
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findByID(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getIdProduct(), product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }
    //    Delete
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findByID(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getIdProduct());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
}
