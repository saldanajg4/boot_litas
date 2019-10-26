package com.spring.service;

import com.spring.entity.Category;

public interface Category_Service {
    com.spring.entity.Category saveCategory(Category cat);
    Iterable<com.spring.entity.Category> listCategories();
    com.spring.entity.Category getCategory(long id);
}
