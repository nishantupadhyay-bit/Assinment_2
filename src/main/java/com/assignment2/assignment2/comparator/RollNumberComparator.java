package com.assignment2.assignment2.comparator;

import com.assignment2.assignment2.model.User;

import java.util.Comparator;

public class RollNumberComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return Integer.compare(user1.getRollNumber(), user2.getRollNumber());
    }
}