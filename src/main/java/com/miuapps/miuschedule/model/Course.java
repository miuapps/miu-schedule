package com.miuapps.miuschedule.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * This is the Course class which every student take during each block.
 */
@Data
public class Course {
    @Id
    private String id;
    private String name;
}
