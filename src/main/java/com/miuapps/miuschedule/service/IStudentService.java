package com.miuapps.miuschedule.service;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;

/**
 * The interface Student service.
 */
public interface IStudentService {
    /**
     * Add user.
     *
     * @param userID   the user id
     * @param courseID the course id
     * @throws CourseRegisterException exception
     */
    public void registerForCourse(String userID, String courseID) throws CourseRegisterException;
}
