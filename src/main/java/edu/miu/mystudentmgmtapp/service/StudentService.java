package edu.miu.mystudentmgmtapp.service;

import edu.miu.mystudentmgmtapp.dto.StudentResponseDTO;
import edu.miu.mystudentmgmtapp.dto.StudentRequestDTO;
import edu.miu.mystudentmgmtapp.exception.StudentNotFoundException;
import edu.miu.mystudentmgmtapp.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAllStudentsDTO();
    StudentResponseDTO findByStudentId(Integer id) throws StudentNotFoundException;
    StudentResponseDTO updateStudent(Integer id, StudentRequestDTO student);
    Student saveStudent(Student student);
    StudentResponseDTO saveNewStudent(StudentRequestDTO student);
    void deleteStudentById(Integer id);
}
