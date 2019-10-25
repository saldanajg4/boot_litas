package com.spring.service;

import com.spring.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface Category_Repository extends CrudRepository<Category, Long> {
}
