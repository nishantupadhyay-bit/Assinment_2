package com.assignment2.assignment2.comparator;

import com.assignment2.assignment2.model.User;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        int result = user1.getName().compareTo(user2.getName());

        if (result != 0) {
            return result;
        }

        return Integer.compare(user1.getRollNumber(), user2.getRollNumber());
    }
}