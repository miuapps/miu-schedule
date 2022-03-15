package com.miuapps.miuschedule.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

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
}
