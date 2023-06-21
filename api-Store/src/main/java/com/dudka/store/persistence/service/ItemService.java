package com.dudka.store.persistence.service;

import com.dudka.store.persistence.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Page<Item> findAll(Pageable pageable);
    List<Item> findAll();
    void saveItem(Item item);
}
