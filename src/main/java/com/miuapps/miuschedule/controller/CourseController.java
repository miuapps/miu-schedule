package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Get courses list.
     *
     * @return the list
     */
    @GetMapping(value = "")
    @ResponseBody
    public List<Course> getCourses(){
        return courseServiceImpl.getCourses();
    }

    /**
     * Gets course by id.
     *
     * @param courseID the course id
     * @return the course by id
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Course getCourseByID(@PathVariable("id") String courseID){
        return courseServiceImpl.getCourseByID(courseID);
    }

    /**
     * Delete course by id.
     *
     * @param courseID the course id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteCourseByID(@PathVariable("id") String courseID){
        courseServiceImpl.deleteCourseByID(courseID);
    }

    @PutMapping(value = "")
    public void updateCourse(@RequestBody Course course){
        courseServiceImpl.updateCourse(course);
    }



}
