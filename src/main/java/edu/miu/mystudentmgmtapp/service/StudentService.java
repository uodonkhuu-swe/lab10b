package edu.miu.mystudentmgmtapp.service;

import edu.miu.mystudentmgmtapp.model.Classroom;
import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findByStudentNumber(String studentNumber);
    Student updateStudent(Student student);
    Student saveStudent(Student student);
    void deleteStudentById(Integer id);
    void addCourse(Course course);
    void addClassroom(Classroom classroom);
}
