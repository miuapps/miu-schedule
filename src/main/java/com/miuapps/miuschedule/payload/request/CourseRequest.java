package com.miuapps.miuschedule.payload.request;

import lombok.Data;

/**
 * The type Course request.
 */
@Data
public class CourseRequest {
    private String name;
    private String code;
    private int capacity;
    private String blockId;
    private String facultyId;
}
