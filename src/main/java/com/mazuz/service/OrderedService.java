package com.mazuz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mazuz.domain.Customer;
import com.mazuz.domain.Product;
import com.mazuz.repositories.CustomerRepository;
import com.mazuz.repositories.OrderedRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import com.mazuz.domain.Ordered;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderedService {

    @Bean(name="h2EntityManagers")
        //@Bean
        //@Qualifier("h2EntityManager")
    CommandLineRunner runner(OrderedService orderedService) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Ordered>> typeReference = new TypeReference<List<Ordered>>() {
            };

            URL url = new URL("http://localhost:8080/ordered/second");
            InputStream inputStream = url.openConnection().getInputStream();

            try {
                List<Ordered> ordereds = mapper.readValue(inputStream, typeReference);
                orderedService.save(ordereds);
                System.out.println("Ordered Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save customers: " + e.getMessage());
            }
        };
    }



    private OrderedRepository orderedRepository;

    public OrderedService(OrderedRepository orderedRepository) {
        this.orderedRepository = orderedRepository;
    }

    public void save(List<Ordered> ordereds) {
        orderedRepository.save(ordereds);
    }

    public Ordered save(Ordered ordered) {
        return orderedRepository.save(ordered);
    }



    private List<Ordered> ordereds = new ArrayList<>(Arrays.asList(
            new Ordered("Pamela Dress","3", "$52","mrred" ),
            new Ordered("Monaco Set in Light Heather Gre","2", "$56","mrpink" )

    ));


    public List<Ordered> getAllOrdered() {
        List<Ordered> ordereds = new ArrayList<>();
        orderedRepository.findAll()
                .forEach(ordereds::add);
        return ordereds;
    }

    public List<Ordered> getAllOrderedSecond() {
        return ordereds;
    }

    public Ordered getOrdered(String id) {
        return  orderedRepository.findOne(id);
    }

    public void addOrdered(Ordered ordered) {
        orderedRepository.save(ordered);
    }

    public void updateOrdered(String id, Ordered ordered) {
        orderedRepository.save(ordered);
    }
    public void deleteOrdered(String id) {
        orderedRepository.delete(id);
    }



}
