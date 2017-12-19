package com.mazuz.controller;

import com.mazuz.domain.Product;
import com.mazuz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/list")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @RequestMapping("/list/second")
    public List<Product> getAllProductSecond(){
        return productService.getAllProductSecond();
    }

    @RequestMapping("/list/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/list")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/list/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable String id) {
        productService.updateProduct(id, product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/list/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}
