package edu.miu.mystudentmgmtapp.controller;

import edu.miu.mystudentmgmtapp.dto.StudentResponseDTO;
import edu.miu.mystudentmgmtapp.dto.StudentRequestDTO;
import edu.miu.mystudentmgmtapp.exception.StudentNotFoundException;
import edu.miu.mystudentmgmtapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/student"})
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping(value = {"/list1001"})
//    public List<Student> StudentList(){
//        return studentService.findAllStudents();
//    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        return ResponseEntity.ok(studentService.findAllStudentsDTO());
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody StudentRequestDTO student){
        return new ResponseEntity<>(studentService.saveNewStudent(student), HttpStatus.CREATED);
    }

    @GetMapping(value = {"/get/{id}"})
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Integer id) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.findByStudentId(id));
    }


    @PutMapping(value = {"/update/{id}"})
    public ResponseEntity<StudentResponseDTO> updateStudentById(@PathVariable Integer id, @RequestBody StudentRequestDTO student) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping(value = {"/delete/{id}"})
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) throws StudentNotFoundException {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
