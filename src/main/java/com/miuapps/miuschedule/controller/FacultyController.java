package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.payload.response.UserResponse;
import com.miuapps.miuschedule.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Faculty controller.
 */
@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyServiceImpl facultyService;

    /**
     * Instantiates a new Faculty controller.
     *
     * @param facultyService the faculty service
     */
    @Autowired
    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }

    /**
     * Gets courses.
     *
     * @param facultyId the faculty id
     * @return the courses
     */
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

    /**
     * Gets faculties.
     *
     * @return the faculties
     */
    @GetMapping(value="")
    public ResponseEntity<List<UserResponse>> getFaculties() {
        List<UserResponse> faculties = facultyService.getFaculties();
        return ResponseEntity.ok(faculties);
    }
}
