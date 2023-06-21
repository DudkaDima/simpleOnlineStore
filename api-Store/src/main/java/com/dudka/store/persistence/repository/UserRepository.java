package com.dudka.store.persistence.repository;

import com.dudka.store.persistence.entity.Order;
import com.dudka.store.persistence.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    List<User> findByEmail(String email, Pageable pageable);

    List<User> findByPhone(String phone, Pageable pageable);


}
