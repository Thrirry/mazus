//package com.mazuz.domain;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name="Product")
//public class Product {
//
//    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO )
//    private String id;
//    private String name;
//    private String details;
//
//    @Column(length=1000000)
//    private String content;
//    private String price;
//    private String size;
//    private String url;
//    private String imgs;
//    private String imgsecond;
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public String getImgs() {
//        return imgs;
//    }
//
//    public void setImgs(String imgs) {
//        this.imgs = imgs;
//    }
//
//    public String getImgsecond() {
//        return imgsecond;
//    }
//
//    public void setImgsecond(String imgsecond) {
//        this.imgsecond = imgsecond;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Product(String id, String name, String details, String content, String price, String size, String url, String imgs, String imgsecond) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.details = details;
//        this.size = size;
//        this.url = url;
//        this.imgs = imgs;
//        this.imgsecond = imgsecond;
//        this.content = content;
//    }
//
//    @SuppressWarnings("unused")
//    public  Product(){}
//
//
//
//
//}
