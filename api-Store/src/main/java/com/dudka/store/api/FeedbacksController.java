package com.dudka.store.api;

import com.dudka.store.persistence.entity.Feedback;
import com.dudka.store.persistence.entity.User;
import com.dudka.store.persistence.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/feedbacks")
@RequiredArgsConstructor
public class FeedbacksController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/getUsers")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUser (@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size,
                                                 @RequestParam(name = "user_id") Long id){

        try{
            List<Feedback> feedbacks = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<Feedback> pageFeedback;
            if(id == null){
                pageFeedback = feedbackService.findAll(paging);

            } else
                pageFeedback = feedbackService.findByUserId(id, paging);
            feedbacks = pageFeedback.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("feedbacks", feedbacks);
            response.put("currentPage", pageFeedback.getNumber());
            response.put("totalItems", pageFeedback.getTotalElements());
            response.put("totalPages", pageFeedback.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/saveFeedback")
    @ResponseBody
    public void saveUser(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
    }
    }

