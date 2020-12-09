package com.codegym.controller;

import com.codegym.entity.Cart;
import com.codegym.entity.Customer;
import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"customer", "cartt"})
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String home(Model model, @ModelAttribute("customer") Customer customer){
        customer.setNameCustomer("Long");
        model.addAttribute("listProduct",productService.findAll());
        return "home";
    }
    @GetMapping("detail")
    public String detailProduct(@RequestParam int id,Model model){
        model.addAttribute("product",productService.findById(id));

        return "product/list";
    }
    @GetMapping("add-to-cart")
    public String addCart(@RequestParam int id,@ModelAttribute("cart") Cart cart){
        if(cart.getProductList().size() == 0){
            List<Product> productList = new ArrayList<>();
            productList.add(productService.findById(id));
            cart.setProductList(productList);
        }else{
            List<Product> productList = cart().getProductList();
            Product product = productService.findById(id);
            productList.add(product);
            cart.setProductList(productList);
        }

        return "cart-product";
    }
    @ModelAttribute("product")
    public Product Product(){
        return new Product();
    }
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @GetMapping("/product")
    public String productList(Model model,
                           @PageableDefault(size = 5) Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("product", this.productService.findAll(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("product", this.productService.searchProductByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keyword", keywordAfterCheck);
        return "product/list";
    }

    @GetMapping("/create-new-product")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-new-product")
    public String CreateNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("Error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.delete(product.getIdProduct());
        return "redirect:/product";
    }
}
