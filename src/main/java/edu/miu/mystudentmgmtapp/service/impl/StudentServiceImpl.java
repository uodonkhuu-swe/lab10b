package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.mystudentmgmtapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList();
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
