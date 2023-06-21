package com.dudka.store.api;

import com.dudka.store.persistence.entity.User;
import com.dudka.store.persistence.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/getUsers")
    @ResponseBody
    public ResponseEntity<List<User>> getUser (@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size){

        return  ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/saveUser")
    @ResponseBody
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
