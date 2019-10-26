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
public class Item extends AuditModel{
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

    @Column(name="category_id",nullable = false)
    private Long category_id;

    @JsonIgnore
    @ManyToMany
    private List<Item> customer_orders = new ArrayList<Item>();

    public Item(){super();}

    private String section;

    public Item( String name, String desc, double price, Long cat, String section){

        this.item_name = name;
        this.description = desc;
        this.price = price;
        this.category_id = cat;
        this.section = section;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Item(String name, String desc, double price, Long cat){

        this.item_name = name;
        this.description = desc;
        this.price = price;
        this.category_id = cat;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
