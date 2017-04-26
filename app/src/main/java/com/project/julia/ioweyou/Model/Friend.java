package com.project.julia.ioweyou.Model;

import java.util.ArrayList;
import java.util.List;

public class Friend {

    private String name;
    private String description;
    private String firstLetter;

    public Friend(String name, String description) {
        this.name = name;
        this.firstLetter = String.valueOf(name.charAt(0));
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public static List<Friend> prepareFriends(String[] names, String[] descriptions) {
        List<Friend> friends = new ArrayList<>(names.length);

        for (int i = 0; i < names.length; i++) {
            Friend friend = new Friend(names[i], descriptions[i]);
            friends.add(friend);
        }

        return friends;
    }
}
