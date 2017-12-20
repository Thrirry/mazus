package com.mazuz.controller;

import com.mazuz.domain.Ordered;
import com.mazuz.domain.Product;
import com.mazuz.service.CustomerService;
import com.mazuz.service.OrderedService;
import com.mazuz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderedController {

    @Autowired
    private OrderedService orderedService;


    @RequestMapping("/ordered")
    public List<Ordered> getAllOrdered(){
        return orderedService.getAllOrdered();
    }

    @RequestMapping("/ordered/second")
    public List<Ordered> getAllOrderedSecond(){
        return orderedService.getAllOrderedSecond();
    }

    @RequestMapping(value = "/ordered/{nameCustomer}", method=RequestMethod.GET)
    public Ordered getOrdered(@PathVariable String nameCustomer) {
        return orderedService.getOrdered(nameCustomer);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/ordered")
    public void addOrdered(@RequestBody Ordered ordered) {
        orderedService.addOrdered(ordered);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/ordered/{id}")
    public void updateOrdered(@RequestBody Ordered ordered, @PathVariable String id) {
        orderedService.updateOrdered(id, ordered);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/ordered/{id}")
    public void deleteOrdered(@PathVariable String id) {
        orderedService.deleteOrdered(id);
    }

}
