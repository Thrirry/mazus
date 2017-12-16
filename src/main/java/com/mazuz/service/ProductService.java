//package com.mazuz.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mazus.domain.Product;
//import com.mazus.domain.User;
//import com.mazus.repository.ProductRepository;
//import com.mazus.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    @Bean
//    CommandLineRunner runner(ProductService productService) {
//        return args -> {
//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
//            };
//
//            URL url = new URL("http://localhost:8080/list/second");
//            InputStream inputStream = url.openConnection().getInputStream();
//
//            //  InputStream inputStream = TypeReference.class.getResourceAsStream("http://localhost:8080/list");
//
//            try {
//                List<Product> products = mapper.readValue(inputStream, typeReference);
//                productService.save(products);
//                System.out.println("Product Saved!");
//            } catch (IOException e) {
//                System.out.println("Unable to save products: " + e.getMessage());
//            }
//        };
//
//
//    }
//
//    private ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//
//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
//
//    public void save(List<Product> products) {
//        productRepository.save(products);
//    }
//
//
//    private List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product("1", "Outerwear", "Scarves & Gloves", "Pull-on pant from NEED in Olive. High rise. Elasticized waistband with interior adjustable drawstrings. Faux fly. Two slant pockets at front. Two welt pockets at back. Tonal stitching. Relaxed fit.", "$86", "S / M / L", "scarves-gloves", "http://localhost:8080/image/nc_06.jpg", "http://localhost:8080/image/hp_nc_07.jpg"),
//            new Product("2", "Sweaters" ,"Monaco Set in Light Heather Grey", "Classic beanie from Norse Projects in Lichen. Fine gauge rib knit. Cuffed design with contrast logo tag. ", "$56", "S / M / L", "monaco-set-in-light-heather-grey", "http://localhost:8080/image/nc_02.jpg" ,"http://localhost:8080/image/nc_02.jpg"),
//            new Product("3", "Tees" ,"Pamela Dress", "Mock neck cardigan sweater from S.N.S. Herning in Navy Blue. Knit crisscross pattern. Mock neck collar. Full button front placket. Ribbed trim. Straight hem. Slim fit.", "$52", "S / M / L", "pamela-dress", "http://localhost:8080/image/nc_03.jpg", "http://localhost:8080/image/nc_06.jpg"),
//            new Product("4", "Sweaters" ,"Jana Sweater", "Knit socks from Chup in Blue or Grey. Elasticized cuff. Ribbed details. Structured toe and heel. Printed logo. ", "$45", "S / M / L", "jana-sweater", "http://localhost:8080/image/nc_04.jpg" ,"http://localhost:8080/image/nc_06.jpg"),
//            new Product("5", "Outerwear" ,"Brook Wide Leg Pants", "Ribbed beanie from NEED in Charcoal. Rolled cuff with woven logo tag.", "$67", "S / M / L", "brook-wide-leg-pants", "http://localhost:8080/image/nc_05.jpg", "http://localhost:8080/image/nc_06.jpg"),
//            new Product("6", "Pants" ,"Cosa Dress", "Low top sneaker from Common Projects in Nude. Lace-up front with flat laces. Lightly padded tongue and collar. Leather lining. Heat pressed gold serial number detail at lateral side. Tonal stitching. Embossed branding at footbed.", "$23", "S / M / L", "cosa-dress", "http://localhost:8080/image/nc_06.jpg","http://localhost:8080/image/nc_06.jpg"),
//            new Product("7", "Shorts" ,"Faretta Blouse","Low top sneaker from Common Projects in Nude. Lace-up front with flat laces. Lightly padded tongue and collar. Leather lining. Heat pressed gold serial number detail at lateral side. Tonal stitching. Embossed branding at footbed.", "$98", "S / M / L","faretta-blouse", "http://localhost:8080/image/nc_07.jpg","http://localhost:8080/image/nc_06.jpg"),
//            new Product("8", "Jumpsuits" ,"Penelope Straight Leg Pant", "Weird Guy Brushed Stretch Selvedge jean from Naked and Famous in Indigo. Mid rise. Button fly with branded top button closure. Five-pocket styling. Exposed selvedge coin pocket detail. Branded leather patch and rivets. Contrast stitching. Brushed exterior. Slim fit. ", "$25", "S / M / L", "penelope-straight-leg-pant", "http://localhost:8080/image/nc_08.jpg","http://localhost:8080/image/nc_06.jpg"),
//            new Product("9", "Activewear" ,"Roxanna Pants", "Classic beanie from Norse Projects in Lichen. Fine gauge rib knit. Cuffed design with contrast logo tag. ", "$92", "S / M / L", "roxanna-pants", "http://localhost:8080/image/nc_09.jpg","http://localhost:8080/image/nc_06.jpg"),
//            new Product("10", "Shorts" ,"Velvet Knit Sweater in Woods Greem", "Ribbed beanie from NEED in Charcoal. Rolled cuff with woven logo tag.", "$60", "S / M / L", "velvet-knit-sweater-in-woods-greem", "http://localhost:8080/image/nc_10.jpg","http://localhost:8080/image/nc_06.jpg"),
//            new Product("20", "NEED" ,"Dye Tee in Dusty Rose", "Pull-on pant from NEED in Olive. High rise. Elasticized waistband with interior adjustable drawstrings. Faux fly. Two slant pockets at front. Two welt pockets at back. Tonal stitching. Relaxed fit.", "$42", "S / M", "dye-tee-in-dusty-rose", "http://localhost:8080/image/nc_11.jpg", "http://localhost:8080/image/nc_06.jpg")
//    ));
//
//
//    public List<Product> getAllProduct() {
//        //return products;
//       List<Product> products = new ArrayList<>();
//        productRepository.findAll()
//        .forEach(products::add);
//           return products;
//    }
//
//    public List<Product> getAllProductSecond() {
//        return products;
//    }
//
//    public Product getProduct(String id) {
//       // return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//        return  productRepository.findOne(id);
//    }
//
//    public void addProduct(Product product) {
//        //products.add(product);
//       productRepository.save(product);
//    }
//
//    public void updateProduct(String id, Product product) {
//        /*for (int i = 0; i < products.size(); i++) {
//            Product t = products.get(i);
//            if (t.getId().equals(id)) {
//                products.set(i, product);
//                return;
//            }
//        }*/
//        productRepository.save(product);
//    }
//    public void deleteProduct(String id) {
//        //products.removeIf(t -> t.getId().equals(id));
//        productRepository.delete(id);
//    }
//
//
//    //public List<Product> list() {
//    //    return productRepository.findAllByOrderByPostedOnAsc();
//    //}
//
//    public Product getByUrl(String url) {
//        return productRepository.findByUrl(url);
//    }
//
//
//}
