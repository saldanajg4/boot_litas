package com.spring.entity;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.*;


@Entity
public class Customer_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long order_id;

    @Column(name="customer", nullable = false)
    private String customer;

    @Column(name="total", nullable = false)
    private double total;

    @Column(name="ordered_At", nullable = false)
    private String ordered_At;

    @Column(name="comments",length = 100,nullable = false)
    private String comments;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="order_items",
    joinColumns = @JoinColumn(name="order_id", referencedColumnName = "order_id"),
    inverseJoinColumns = @JoinColumn(name="item_id", referencedColumnName = "item_id"))
    private Set<Item> itemList;

    public Customer_Order(){super();}

    public Customer_Order(String customer, double total, String o, String c, Set<Item> items){
        this.customer = customer;
        this.total = total;
        this.ordered_At = o;
        this.comments = c;
        this.itemList = items;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Set<Item> items) {
        double total=0;
        for(Item item : items){
            total += item.getPrice();
        }
        this.total = total;
    }

    public String getOrdered_At() {
        return ordered_At;
    }

    public void setOrdered_At(String ordered_At) {
        this.ordered_At = ordered_At;
    }
    @Override
    public String toString(){
        return "Customer_Order{" +
                "id=" + order_id +
                ", customer='" + customer + '\'' +
                ", total=" + total +
                ", ordered_At='" + ordered_At + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
