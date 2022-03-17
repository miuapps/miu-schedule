package com.miuapps.miuschedule.payload.response;

import com.miuapps.miuschedule.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseBlockResponse {
    private String blockName;
    private List<Course> courses;
}
