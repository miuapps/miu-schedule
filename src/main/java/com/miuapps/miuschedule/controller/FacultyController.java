package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyServiceImpl facultyService;

    @Autowired
    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping(value = "courses")
    public ResponseEntity<List<Course>> getCourses(@RequestParam String facultyId) {
        try {
            List<Course> courses = facultyService.getCoursesByFacultyId(facultyId);
            return ResponseEntity.ok(courses);
        } catch (CourseRegisterException exc) {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }
}
