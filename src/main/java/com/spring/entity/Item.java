package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.*;


//@Data
//@EqualsAndHashCode(exclude="customer_orders")
@Entity
//public class Item extends AuditModel{
public class Item{
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

//    @Column(name="category_id",nullable = false)
//    private Long category_id;

    @JsonIgnore
    @ManyToMany
    private List<Item> customer_orders = new ArrayList<Item>();

//    @OneToMany(cascade = CascadeType.ALL,
//    fetch=FetchType.LAZY,
//    mappedBy = "item")
//    private Set<Ingredient> ingredientSet = new HashSet<Ingredient>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="item_ingredients",
            joinColumns = @JoinColumn(name="item_id", referencedColumnName = "item_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id", referencedColumnName = "ingredient_id"))
    private Set<Ingredient> ingredientSet;

    @OneToOne
    @JoinColumn(name="section_id")
    private Section sectionObject;

    @OneToOne
    @JoinColumn(name="category_id")
    private Category categoryObject;

    public Item(){super();}


//    public Item( String name, String desc, double price, Long cat, String section){
public Item( String name, String desc, double price){

        this.item_name = name;
        this.description = desc;
        this.price = price;
    }

    public Category getCategoryObject() {
        return categoryObject;
    }

    public void setCategoryObject(Category categoryObject) {
        this.categoryObject = categoryObject;
    }

    public Section getSectionObject() {
        return sectionObject;
    }

    public void setSectionObject(Section sectionObject) {
        this.sectionObject = sectionObject;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Set<Ingredient> getIngredientSet() {
        return ingredientSet;
    }

    public void setIngredientSet(Set<Ingredient> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

//    public Item(String name, String desc, double price, Long cat){
    public Item(String name, String desc, double price, Long cat){
        this.item_name = name;
        this.description = desc;
        this.price = price;
//        this.category_id = cat;
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
