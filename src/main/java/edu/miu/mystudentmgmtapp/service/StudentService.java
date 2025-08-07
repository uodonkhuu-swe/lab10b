package edu.miu.mystudentmgmtapp.service;

import edu.miu.mystudentmgmtapp.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    Student updateStudent(Student student);
    Student saveStudent(Student student);
    void deleteStudentById(Integer id);
}
