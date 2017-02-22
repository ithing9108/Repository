package com.example.user.sps;

import java.io.Serializable;

/**
 * Created by main on 2016-06-06.
 */
public class Product implements Serializable{

    public String state = "";
    public String pw = "";
    public String loanee = "";
    public String date = "";
    public String price = "";
    public String name="";
    public String category="";
    public String classification="";
    public String qqq="";

    public Product (String s,String d, String p, String l,String pw){
        this.state = s;
        this.pw = pw;
        this.loanee = l;
        this.date = d;
        this.price = p;
    }

    public Product(String qqq, String classification, String category, String name, String price, String date) {
        this.qqq = qqq;
        this.classification = classification;
        this.category = category;
        this.name = name;
        this.price = price;
        this.date = date;
    }
}
