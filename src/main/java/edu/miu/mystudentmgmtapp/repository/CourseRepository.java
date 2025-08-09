package edu.miu.mystudentmgmtapp.repository;

import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer> {

//    @Query(value = "select c from Course c join fetch c.students")
//    List<Course> findAllCoursesAndStudents();
//
////    @Query(value = """
////        select * from courses c left outer join students s on c.student_id
////    """, nativeQuery = true)
//    List<Course> findAllCoursesAndStudentsNativeQuery();
}
