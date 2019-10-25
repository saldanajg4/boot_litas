package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//@Data
//@EqualsAndHashCode(exclude="customer_orders")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long item_id;

    @Column(name="item_name", nullable = false)
    private String item_name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="price", nullable = false)
    private double price;

    @JsonIgnore
    @ManyToMany
    private List<Item> customer_orders = new ArrayList<Item>();

    public Item(){super();}
//    public Item(long id){
//        this.item_id = id;
//    }

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(unique = false)
//    private Category category;
    private String category;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(unique = false)
//    private Section section;
    private String section;

    public Item( String name, String desc, double price, String cat, String section){

        this.item_name = name;
        this.description = desc;
        this.price = price;
        this.category = cat;
        this.section = section;
    }
    public Item( String name, String desc, double price, String cat){

        this.item_name = name;
        this.description = desc;
        this.price = price;
        this.category = cat;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Item> getCustomer_orders() {
        return customer_orders;
    }

    public void setCustomer_orders(List<Item> customer_orders) {
        this.customer_orders = customer_orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
