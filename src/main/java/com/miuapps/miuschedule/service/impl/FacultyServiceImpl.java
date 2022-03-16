package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.model.ERole;
import com.miuapps.miuschedule.model.User;
import com.miuapps.miuschedule.payload.response.UserResponse;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.repository.UserRepository;
import com.miuapps.miuschedule.service.IFacultyService;
import com.miuapps.miuschedule.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Faculty service.
 */
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

    @Override
    public List<UserResponse> getFaculties() {
        List<User> users = userRepository.findAll();
        List<User> faculties = users.stream().filter(user -> user.getRoles().stream()
                .anyMatch(role -> role.getName().equals(ERole.ROLE_FACULTY))).toList();
        List<UserResponse> editedFaculties = new ArrayList<>();
        for(User faculty : faculties) {
            editedFaculties.add(new UserResponse(faculty.getId(), faculty.getUsername()));
        }
        return editedFaculties;
    }
}
