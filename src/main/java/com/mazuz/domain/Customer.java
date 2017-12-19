package com.mazuz.domain;

import javax.persistence.*;


@Entity
@Table(name="Customer")
public class Customer {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private String Stt;
    private String id;
    private String managername;
    private String manageremail;
    private String managerpassword;
    private String manageradress;
    private String managerphone;
    private String managergender;


    public String getStt() {
        return Stt;
    }

    public void setStt(String stt) {
        Stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManageremail() {
        return manageremail;
    }

    public void setManageremail(String manageremail) {
        this.manageremail = manageremail;
    }

    public String getManagerpassword() {
        return managerpassword;
    }

    public void setManagerpassword(String managerpassword) {
        this.managerpassword = managerpassword;
    }

    public String getManageradress() {
        return manageradress;
    }

    public void setManageradress(String manageradress) {
        this.manageradress = manageradress;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public String getManagergender() {
        return managergender;
    }

    public void setManagergender(String managergender) {
        this.managergender = managergender;
    }


    public Customer(String id, String managername, String manageremail, String managerpassword, String manageradress, String managerphone, String managergender) {

        this.id = id;
        this.managername = managername;
        this.manageremail = manageremail;
        this.managerpassword = managerpassword;
        this.manageradress = manageradress;
        this.managerphone = managerphone;
        this.managergender = managergender;
    }
    @SuppressWarnings("unused")
    public Customer(){}
}
