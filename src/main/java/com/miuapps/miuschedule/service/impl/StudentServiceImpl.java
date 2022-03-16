package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.model.ERole;
import com.miuapps.miuschedule.model.User;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.repository.UserRepository;
import com.miuapps.miuschedule.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Student service.
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private Course course;
    private User user;

    /**
     * Instantiates a new Student service.
     *
     * @param courseRepository the course repository
     * @param userRepository   the user repository
     */
    @Autowired
    public StudentServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerForCourse(String userID, String courseID) throws CourseRegisterException{
        course = courseRepository.findCourseById(courseID);
        if(course == null) {
            throw new CourseRegisterException("Given course id does not belongs to a course.");
        }
        user = userRepository.findUserById(userID);
        boolean isStudent = user.getRoles().stream().anyMatch(role -> role.getName().equals(ERole.ROLE_STUDENT));
        if(!isStudent) {
            throw new CourseRegisterException("Given user id does not belongs to a student.");
        }
        if (course.getUserList() != null && course.getUserList().size() < course.getCapacity()) {
            courseRepository.deleteById(course.getId());
            course.addUser(user);
            courseRepository.save(course);
        } else {
            throw new CourseRegisterException("Course capacity is not enough.");
        }
    }
}
