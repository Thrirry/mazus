package com.mazuz.controller;

import com.mazuz.domain.Gifts;
import com.mazuz.domain.Product;
import com.mazuz.service.GiftsService;
import com.mazuz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GiftsController {

    @Autowired
    private GiftsService giftsService;


    @RequestMapping("/gifts")
    public List<Gifts> getAllGifts(){
        return giftsService.getAllGifts();
    }

    @RequestMapping("/gifts/second")
    public List<Gifts> getAllGiftsSecond(){
        return giftsService.getAllGiftsSecond();
    }

    @RequestMapping("/gifts/{id}")
    public Gifts getGifts(@PathVariable String id) {
        return giftsService.getGifts(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/gifts")
    public void addGifts(@RequestBody Gifts gifts) {
        giftsService.addGifts(gifts);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/gifts/{id}")
    public void updateGifts(@RequestBody Gifts gifts, @PathVariable String id) {
        giftsService.updateGifts(id, gifts);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/gifts/{id}")
    public void deleteGifts(@PathVariable String id) {
        giftsService.deleteGifts(id);
    }

}
