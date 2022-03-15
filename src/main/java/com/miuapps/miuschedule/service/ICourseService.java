package com.miuapps.miuschedule.service;

import com.miuapps.miuschedule.model.Course;

import java.util.List;

/**
 * The interface Course service.
 */
public interface ICourseService {
    /**
     * send course to repository.
     *
     * @param course the course
     */
    void saveCourse(Course course);

    /**
     * Gets all courses.
     *
     * @return the courses
     */
    List<Course> getCourses();

    /**
     * Gets course by ID.
     *
     * @param courseID the course id
     * @return the course by id
     */
    Course getCourseByID(String courseID);

    /**
     * Delete course by ID.
     *
     * @param courseID the course id
     */
    void deleteCourseByID(String courseID);

    void updateCourse(Course course);

}

