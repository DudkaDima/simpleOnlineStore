package com.dudka.store.persistence.service;

import com.dudka.store.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();
    void saveCategory(Category category);
}
