package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.model.Course;
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
    public void addUser(String userID, String courseID) {
        course = courseRepository.findCourseById(courseID);
        user = userRepository.findUserById(userID);
        if (course.getUserList().size() < course.getCapacity()) {
            courseRepository.deleteById(course.getId());
            course.addUser(user);
            courseRepository.save(course);
        }
//            if(user.getRoles().equals(ERole.ROLE_STUDENT)){
//                course.addUser(user);
//            }else{
//                //Mesut please implement
//            }
//        }
        else {
            System.out.println("full capacity");
        }
    }
}
