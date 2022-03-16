package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.payload.response.MessageResponse;
import com.miuapps.miuschedule.service.impl.FacultyServiceImpl;
import com.miuapps.miuschedule.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MessageResponse> addCourse(@RequestParam String userId,
                                                     @RequestParam String courseId){
        try {
            studentServiceImpl.registerForCourse(userId, courseId);
            return ResponseEntity.ok(new MessageResponse("Course registration successful."));
        } catch (CourseRegisterException exc) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(exc.getMessage()));
        }

    }


}
