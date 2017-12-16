//package com.mazuz.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mazus.domain.Customer;
//import com.mazus.domain.Product;
//import com.mazus.repository.CustomerRepository;
//import com.mazus.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class CustomerService {
//
//
//    @Bean(name="h2EntityManager")
//    CommandLineRunner runner(CustomerService customerService) {
//        return args -> {
//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
//            };
//
//            URL url = new URL("http://localhost:8080/api/customer/second");
//            InputStream inputStream = url.openConnection().getInputStream();
//
//            try {
//                List<Customer> customers = mapper.readValue(inputStream, typeReference);
//                customerService.save(customers);
//                System.out.println("Customer Saved!");
//            } catch (IOException e) {
//                System.out.println("Unable to save customers: " + e.getMessage());
//            }
//        };
//    }
//
//
//
//   private CustomerRepository customerRepository;
//
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//
//    public Customer save(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public void save(List<Customer> customers) {
//        customerRepository.save(customers);
//    }
//
//
//    private List<Customer> customers = new ArrayList<>(Arrays.asList(
//            new Customer("1","mrred", "mrred@mazus.com", "asas", "27 Yen Bai", "0988972771", "female"),
//            new Customer("2","mrblue", "mrblue@mazus.com", "adad", "24 Hoang Dieu", "098816262", "male"),
//            new Customer("3","mrpink", "mrpink@mazus.com", "dfdf", "237 Ton Duc Thang", "098122731", "female"),
//            new Customer("4","mrwhite", "mrwhite@mazus.com", "cdcd", "123 Ton That Tung", "091122133", "female"),
//            new Customer("5","mrblack", "mrblack@mazus.com", "vfvf", "12 Le Duan", "04423233", "male"),
//            new Customer("6","mrbrown", "mrbrown@mazus.com", "cvcv", "12 Truong Chinh", "098112122", "female")
//    ));
//
//
//    public List<Customer> getAllCustomer() {
//       List<Customer> customers = new ArrayList<>();
//        customerRepository.findAll()
//                .forEach(customers::add);
//        return customers;
//
//       // return customers;
//
//    }
//
//    public List<Customer> getAllCustomerSecond() {
//
//        return customers;
//
//    }
//
//    public Customer getCustomer(String id) {
//        return  customerRepository.findOne(id);
//    }
//
//    public void addCustomer(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    public void updateCustomer(String id, Customer customer) {
//        customerRepository.save(customer);
//    }
//    public void deleteCustomer(String id) {
//        customerRepository.delete(id);
//    }
//
//
//}
