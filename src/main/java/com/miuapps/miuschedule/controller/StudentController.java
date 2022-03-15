package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Student controller.
 */
@RestController
@RequestMapping("student")
public class StudentController {
    private StudentServiceImpl studentServiceImpl;

    /**
     * Instantiates a new Student controller.
     *
     * @param studentServiceImpl the student service
     */
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    /**
     * Register course.
     *
     * @param userId   the user id
     * @param courseId the course id
     */
    @GetMapping(value = "/registerCourse")
    public void addCourse(@RequestParam String userId,
                               @RequestParam String courseId){
        studentServiceImpl.addUser(userId, courseId);
    }
}
