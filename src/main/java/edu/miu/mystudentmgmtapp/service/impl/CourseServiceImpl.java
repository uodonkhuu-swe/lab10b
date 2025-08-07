package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.repository.CourseRepository;
import edu.miu.mystudentmgmtapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository classroomRepository;

    @Autowired
    public void setCourseRepository(CourseRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return classroomRepository.save(course);
    }
}
