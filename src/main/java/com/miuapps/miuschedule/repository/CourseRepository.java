package com.miuapps.miuschedule.repository;

import com.miuapps.miuschedule.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;



/**
 * The interface Course repository.
 */
public interface CourseRepository extends MongoRepository<Course, String> {
    /**
     * Find course by id course.
     *
     * @param courseID the course id
     * @return the course
     */
    Course findCourseById(String courseID);

    /**
     * Find course by name course.
     *
     * @param blockName the block name
     * @return the course
     */
    Course findCourseByName(String blockName);
}
