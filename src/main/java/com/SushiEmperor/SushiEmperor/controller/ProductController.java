package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productPage(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/product_list")
    public String getProductListPage(Model model){
        model.addAttribute("productRequest", new Product());
        return "product_list";
    }

    @PostMapping("/product_list")
    public String addProduct(@ModelAttribute Product product){
        System.out.println("product request: " + product);
        Product adedpr = productService.save(product.getName(), product.getPrice());
        return "redirect:/admin";
    }
}
