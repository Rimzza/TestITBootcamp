package com.nikita.testtask.services;


import com.nikita.testtask.Compare;
import com.nikita.testtask.models.User;
import com.nikita.testtask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    public void delete (int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllSorted(){
        List<User> users = findAll();
        Collections.sort(users,new Compare());
        return users;
    }


}
