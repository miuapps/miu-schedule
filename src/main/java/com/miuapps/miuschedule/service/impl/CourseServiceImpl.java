package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.exceptions.CourseRegisterException;
import com.miuapps.miuschedule.model.*;
import com.miuapps.miuschedule.payload.request.CourseRequest;
import com.miuapps.miuschedule.repository.BlockRepository;
import com.miuapps.miuschedule.repository.CourseRepository;
import com.miuapps.miuschedule.repository.UserRepository;
import com.miuapps.miuschedule.service.ICourseService;
import com.miuapps.miuschedule.util.ScheduleUtil;
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
    private final BlockRepository blockRepository;
    private final UserRepository userRepository;
    /**
     * Instantiates a new Course service.
     * calling repository save from this service implementations.
     *
     * @param courseRepository the course repository
     */
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, BlockRepository blockRepository,
                             UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.blockRepository = blockRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveCourse(CourseRequest courseRequest) throws CourseRegisterException {
        Block block = blockRepository.findBlockById(courseRequest.getBlockId());
        User faculty = userRepository.findUserById(courseRequest.getFacultyId());
        if(ScheduleUtil.isFaculty(faculty) && ScheduleUtil.isBlockExist(block)) {
            Course course = new Course(courseRequest.getName(),courseRequest.getCode(),
                    courseRequest.getCapacity(),
                    block, faculty);
            courseRepository.save(course);
        }
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
