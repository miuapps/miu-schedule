package com.miuapps.miuschedule.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;

/**
 * Block is duration of studying the course.
 */
@Data
public class Block {
    @Id
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;
}
