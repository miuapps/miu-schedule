package com.miuapps.miuschedule.service;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.payload.response.UserResponse;

import java.util.List;

public interface IFacultyService {
    public List<Course> getCoursesByFacultyId(String facultyId) throws CourseRegisterException;
    public List<UserResponse> getFaculties();
}
