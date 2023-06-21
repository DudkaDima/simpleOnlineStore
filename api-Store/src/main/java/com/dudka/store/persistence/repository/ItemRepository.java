package com.dudka.store.persistence.repository;

import com.dudka.store.persistence.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
