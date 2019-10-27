package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Section {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="section_id")
    private Long section_id;

    @Column(name="section_name", nullable = false)
    private String section_name;

    public Section(){}

    public Section(Long id,String name){
        this.section_id = id;
        this.section_name = name;
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

}
