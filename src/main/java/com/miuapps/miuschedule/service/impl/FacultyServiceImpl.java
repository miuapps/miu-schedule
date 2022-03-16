package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.model.User;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.repository.UserRepository;
import com.miuapps.miuschedule.service.IFacultyService;
import com.miuapps.miuschedule.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements IFacultyService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    /**
     * Instantiates a new Student service.
     *
     * @param courseRepository the course repository
     * @param userRepository   the user repository
     */
    @Autowired
    public FacultyServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Course> getCoursesByFacultyId(String facultyId) throws CourseRegisterException {
        User faculty = userRepository.findUserById(facultyId);
        List<Course> allCourses = courseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        if(ScheduleUtil.isFaculty(faculty) ) {
            for(Course course : allCourses) {
                if(course.getFaculty().getId().equals(facultyId)) {
                    courses.add(course);
                }
            }
        }
        return courses;
    }
}
