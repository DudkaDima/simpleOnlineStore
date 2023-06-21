package com.dudka.store.persistence.service.implementation;

import com.dudka.store.persistence.entity.Feedback;
import com.dudka.store.persistence.repository.FeedbackRepository;
import com.dudka.store.persistence.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        return feedbackRepository.findAll(pageable);

    }

    @Override
    public Page<Feedback> findByUserId(Long id, Pageable pageable) {
        return feedbackRepository.findByUserId(id, pageable);
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
