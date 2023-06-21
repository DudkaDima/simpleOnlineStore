package com.dudka.store.persistence.service;

import com.dudka.store.persistence.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeedbackService {
    Page<Feedback> findAll(Pageable pageable);
    Page<Feedback> findByUserId(Long id, Pageable pageable);

    void save(Feedback feedback);
}
