package edu.miu.mystudentmgmtapp.repository;

import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer> {
}
