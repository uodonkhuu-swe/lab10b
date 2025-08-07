package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.model.Classroom;
import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.mystudentmgmtapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public Student findByStudentNumber(String studentNumber) {
        return studentRepository
                .findByStudentNumber(studentNumber)
                .orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student saveStudent(Student student) {
        Optional<Student> existing = studentRepository.findByStudentNumber(student.getStudentNumber());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Student already exists");
        } else {
            return studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public void addClassroom(Classroom classroom) {

    }
}
