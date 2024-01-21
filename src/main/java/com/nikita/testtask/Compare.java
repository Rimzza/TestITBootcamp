package com.nikita.testtask;

import com.nikita.testtask.models.User;

import java.util.Comparator;

public class Compare implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
