package com.mazuz.domain;


import javax.persistence.*;

@Entity
@Table(name="Gifts")
public class Gifts {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private String stt;
    private String id;
    private String name;
    private String details;

    @Column(length=1000000)
    private String price;
    private String size;
    private String url;
    private String img;
    private String namestock;

    public String getNamestock() {
        return namestock;
    }

    public void setNamestock(String namestock) {
        this.namestock = namestock;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Gifts(String id, String namestock, String name, String details, String price, String size, String url, String img) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.size = size;
        this.url = url;
        this.img = img;
        this.namestock = namestock;
    }

    public Gifts(){}
}
