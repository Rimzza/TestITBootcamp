package com.nikita.testtask.restcontrollers;


import com.nikita.testtask.models.User;
import com.nikita.testtask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usersJson")
public class UserRestControllers {

    private final UserService userService;

    @Autowired
    public UserRestControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") int id) {
        return  userService.findOne(id);
    }
}
