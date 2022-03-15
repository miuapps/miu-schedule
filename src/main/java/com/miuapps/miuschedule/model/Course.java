package com.miuapps.miuschedule.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Course class which every student take during each block.
 */
@Data
public class Course {
    @Id
    private String id;
    private String name;
    private String code;
    private int capacity;
    @DBRef
    private Block block;
    /**
     * The User list.
     */
    @DBRef
    List<User> userList = new ArrayList<>();

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user){
        userList.add(user);
    }

}
