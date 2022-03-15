package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Course service.
 */
@Service
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;

    /**
     * Instantiates a new Course service.
     * calling repository save from this service implementations.
     *
     * @param courseRepository the course repository
     */
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByID(String courseID) {
        return courseRepository.findCourseById(courseID);
    }

    @Override
    public void deleteCourseByID(String courseID) {
        courseRepository.deleteById(courseID);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.deleteById(course.getId());
        courseRepository.save(course);
    }
}
