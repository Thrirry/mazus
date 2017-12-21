package com.mazuz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mazuz.domain.Gifts;
import com.mazuz.domain.Ordered;
import com.mazuz.domain.Product;
import com.mazuz.repositories.GiftsRepository;
import com.mazuz.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GiftsService {

    @Bean(name="h2EntityManagers2")
    CommandLineRunner runner(GiftsService giftsService) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Gifts>> typeReference = new TypeReference<List<Gifts>>() {
            };

            URL url = new URL("http://localhost:8080/gifts/second");
            InputStream inputStream = url.openConnection().getInputStream();
            try {
                List<Gifts> gifts = mapper.readValue(inputStream, typeReference);
                giftsService.save(gifts);
                System.out.println("Gifts Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save gifts: " + e.getMessage());
            }
        };
    }
    private GiftsRepository giftsRepository;
    public GiftsService(GiftsRepository giftsRepository ) {
        this.giftsRepository = giftsRepository;
    }
    public Gifts save(Gifts gift) {
        return giftsRepository.save(gift);
    }
    public void save(List<Gifts> gifts) {
        giftsRepository.save(gifts);
    }


    private List<Gifts> gifts = new ArrayList<>(Arrays.asList(

            new Gifts("1", "exclusive", "Luminizer X Quad" , "", "$40", "", "Luminizer-X-Quad", "http://localhost:8080/image/gift/gift1.jpg" ),
            new Gifts("2", "", "Faro Mug Coffee Service Set" , "", "$202", "", "Faro-Mug-Coffee-Service-Set", "http://localhost:8080/image/gift/gift2.jpg" ),
            new Gifts("3","", "2018 Year Task Planner in Copper" , "", "$20", "", "2018-Year-Task-Planner-in-Copper", "http://localhost:8080/image/gift/gift3.jpg" ),
            new Gifts("4","exclusive", "Northern Lights Socks" , "", "$100", "", "Northern-Lights-Socks", "http://localhost:8080/image/gift/gift4.jpg" ),
            new Gifts("5","", "Hairsheep Cashmere Gloves in Camel" , "", "$23", "", "Hairsheep-Cashmere-Gloves-in-Camel", "http://localhost:8080/image/gift/gift5.jpg" ),
            new Gifts("6","", "The Vices Votive Set" , "", "$99", "", "The-Vices-Votive-Set", "http://localhost:8080/image/gift/gift6.jpg" ),
            new Gifts("7","back-in-stock", "Silver Lining 17oz. Bottle" , "", "$99", "", "Silver-Lining-17oz.-Bottle", "http://localhost:8080/image/gift/gift7.jpg" ),
            new Gifts("8","", "Octahedron Ring Planter Short" , "", "$101", "", "Octahedron-Ring-Planter-Short", "http://localhost:8080/image/gift/gift8.jpg" ),
            new Gifts("9","", "Sock / Forty-Eight in White" , "", "$98", "", "Sock-Forty-Eight-in-White", "http://localhost:8080/image/gift/gift9.jpg" ),
            new Gifts("10","back-in-stock", "Skin Rescue Essentials Kit" , "", "$70", "", "Skin-Rescue-Essentials-Kit", "http://localhost:8080/image/gift/gift10.jpg" ),
            new Gifts("11","", "Nep Rib 3-Pack Crew" , "", "$65", "", "Nep-Rib-3-Pack-Crew", "http://localhost:8080/image/gift/gift11.jpg" ),
            new Gifts("12","back-in-stock", "Perception Set" , "", "$60", "", "Perception-Set", "http://localhost:8080/image/gift/gift12.jpg" )

    ));

    public List<Gifts> getAllGifts() {
        List<Gifts> gifts = new ArrayList<>();
        giftsRepository.findAll()
                .forEach(gifts::add);
        return gifts;
    }

    public List<Gifts> getAllGiftsSecond() {
        return gifts;
    }

    public Gifts getGifts(String id) {
        return  giftsRepository.findOne(id);
    }

    public void addGifts(Gifts gifts) {
        giftsRepository.save(gifts);
    }

    public void updateGifts(String id, Gifts gifts) {
        giftsRepository.save(gifts);
    }

    public void deleteGifts(String id) {
        giftsRepository.delete(id);
    }

    public Gifts getByUrl(String url) {
        return giftsRepository.findByUrl(url);
    }
}
