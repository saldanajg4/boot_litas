package com.spring.entity;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long category_id;

    @Column(name="category_name", nullable = false)
    private String category_name;

//    @OneToOne(mappedBy = "category")
//    private Item item;

    public Category(){}

    public Category(String cat){
        this.category_name=cat;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
