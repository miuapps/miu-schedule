package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Course controller.
 */
@RestController
@RequestMapping("course")
public class CourseController {
    private final CourseServiceImpl courseServiceImpl;

    /**
     * Instantiates a new Course controller.
     *
     * @param courseService the course service
     */
    @Autowired
    public CourseController(CourseServiceImpl courseService){
        this.courseServiceImpl = courseService;
    }

    /**
     * Save course.
     *
     * @param course the course
     */
    @PostMapping(value = "")
    public void saveCourse(@RequestBody Course course){
        courseServiceImpl.saveCourse(course);
    }
}
