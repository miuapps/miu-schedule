package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.model.Course;
import com.miuapps.miuschedule.model.ERole;
import com.miuapps.miuschedule.model.Role;
import com.miuapps.miuschedule.model.User;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.repository.UserRepository;
import com.miuapps.miuschedule.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course service.
 */
@Service
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;
//    @Autowired
//    private UserRepository userRepository;
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
//
//    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
//        this.courseRepository = courseRepository;
//        this.userRepository = userRepository;
//    }

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

//    @Override
//    public List<Course> getCoursesByFid(String Fid) {
//        List<Course> taught = new ArrayList<>();
//        List<Course> allCourses = courseRepository.findAll();
//        List<User> allUser;
//        User user = userRepository.findUserById(Fid);
//        if(user.getRoles().contains(new Role(ERole.ROLE_FACULTY))){
//            System.out.println("inside");
//            for(Course c: allCourses){
//                allUser = c.getUserList();
//                for(User us:allUser){
//                    if(us.getId().equals(Fid)){
//                        taught.add(c);
//                        break;
//                    }
//                }
//            }
//        }
//        return taught;
//    }
}
