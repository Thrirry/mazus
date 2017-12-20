package com.mazuz.domain;


import javax.persistence.*;

@Entity
@Table(name="Ordered")
public class Ordered {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private String stt;
    private String nameproduct;
    private String idproduct;
    private String price;
    private String nameCustomer;

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Ordered( String nameproduct, String idproduct, String price, String nameCustomer) {
        super();
        this.nameproduct = nameproduct;
        this.idproduct = idproduct;
        this.price = price;
        this.nameCustomer = nameCustomer;
    }
    @SuppressWarnings("unused")
    public Ordered(){}
}
