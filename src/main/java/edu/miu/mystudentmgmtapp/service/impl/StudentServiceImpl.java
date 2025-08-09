package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.dto.StudentResponseDTO;
import edu.miu.mystudentmgmtapp.dto.StudentRequestDTO;
import edu.miu.mystudentmgmtapp.dto.TranscriptResponseDTO;
import edu.miu.mystudentmgmtapp.exception.StudentNotFoundException;
import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.model.Transcript;
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
    public List<StudentResponseDTO> findAllStudentsDTO() {
        return studentRepository
                .findAll()
                .stream()
                .map(
                        p -> new StudentResponseDTO(
                                p.getId(),
                                p.getStudentNumber(),
                                p.getFirstName(),
                                p.getMiddleName(),
                                p.getLastName(),
                                p.getCgpa(),
                                p.getDateOfEnrollment(),
                                getTranscriptDTO(p)
                        )
                )
                .sorted(Comparator.comparing(StudentResponseDTO::firstName))
                .toList();
    }

    private TranscriptResponseDTO getTranscriptDTO(Student student) {
        if(student.getTranscript() == null) return null;
        return new TranscriptResponseDTO(student.getTranscript().getId(), student.getTranscript().getDegreeTitle());
    }

    @Override
    public StudentResponseDTO findByStudentId(Integer id) throws StudentNotFoundException {
        var student = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException(String.format("Student with Id: %s not found", id)));

        return new StudentResponseDTO(
                student.getId(),
                student.getStudentNumber(),
                student.getFirstName(),
                student.getMiddleName(),
                student.getLastName(),
                student.getCgpa(),
                student.getDateOfEnrollment(),
                getTranscriptDTO(student)
                );
    }

    @Override
    public StudentResponseDTO updateStudent(Integer id, StudentRequestDTO editedStudent) {
        var student = studentRepository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException(String.format("Invalid Id: %s", id)));

        student.setFirstName(editedStudent.firstName());
        student.setMiddleName(editedStudent.middleName());
        student.setLastName(editedStudent.lastName());
        student.setStudentNumber(editedStudent.studentNumber());
        student.setCgpa(editedStudent.cgpa());
        student.setDateOfEnrollment(editedStudent.dateOfEnrollment());
        var updatedStudent = studentRepository.save(student);

        return new StudentResponseDTO(
                updatedStudent.getId(),
                updatedStudent.getStudentNumber(),
                updatedStudent.getFirstName(),
                updatedStudent.getMiddleName(),
                updatedStudent.getLastName(),
                updatedStudent.getCgpa(),
                updatedStudent.getDateOfEnrollment(),
                getTranscriptDTO(updatedStudent)
        );
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
    public StudentResponseDTO saveNewStudent(StudentRequestDTO student) {
        var newStudent = new Student(
                null,
                student.studentNumber(),
                student.firstName(),
                student.middleName(),
                student.lastName(),
                student.cgpa(),
                student.dateOfEnrollment(),
                new Transcript(null,student.transcript().degreeTitle(),null),
                null,
                null
        );
        var savedStudent = saveStudent(newStudent);
        return new StudentResponseDTO(
                savedStudent.getId(),
                savedStudent.getStudentNumber(),
                savedStudent.getFirstName(),
                savedStudent.getMiddleName(),
                savedStudent.getLastName(),
                savedStudent.getCgpa(),
                savedStudent.getDateOfEnrollment(),
                getTranscriptDTO(savedStudent)
        );
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
