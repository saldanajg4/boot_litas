package com.spring.service;

import com.spring.entity.Category;

public interface Category_Service {
    Iterable<Category> listCategories();
    Category getCategory(long id);
}
