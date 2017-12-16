//package com.mazuz.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mazus.domain.Address;
//import com.mazus.domain.Product;
//import com.mazus.domain.User;
//import com.mazus.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class UserService {
//
//   /* @Bean
//    CommandLineRunner runner(UserService userService) {
//        return args -> {
//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
//            };
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//            try {
//                List<User> users = mapper.readValue(inputStream, typeReference);
//                userService.save(users);
//                System.out.println("Users Saved!");
//            } catch (IOException e) {
//                System.out.println("Unable to save users: " + e.getMessage());
//            }
//        };
//    }
//
//    private UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public Iterable<User> list() {
//        return userRepository.findAll();
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    public void save(List<User> users) {
//        userRepository.save(users);
//    }
//
//    private List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product("11", "Blue", "$1"),
//            new Product("22", "Read", "$2"),
//            new Product("33", "Yellow", "$3")
//    ));
//
//
//    public List<Product> getAllProduct() {
//        return products;
//    }
//
//    public Product getProduct(String id) {
//        return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//    }
//
//    public void addProduct(Product product) {
//       products.add(product);
//    }
//
//    public void updateProduct(String id, Product product) {
//        for (int i = 0; i < products.size(); i++) {
//            Product t = products.get(i);
//            if (t.getId().equals(id)) {
//                products.set(i, product);
//                return;
//            }
//        }
//    }
//    public void deleteProduct(String id) {
//        products.removeIf(t -> t.getId().equals(id));
//    } */
//}
