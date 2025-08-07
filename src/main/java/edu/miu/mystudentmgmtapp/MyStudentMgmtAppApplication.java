package edu.miu.mystudentmgmtapp;

import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.mystudentmgmtapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    private final StudentService studentService;

    public MyStudentMgmtAppApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var student1 = new Student();
        student1.setStudentNumber("000-61-0001");
        student1.setFirstName("Anna");
        student1.setMiddleName("Lynn");
        student1.setLastName("Smith");
        student1.setCgpa(3.45);
        student1.setDateOfEnrollment(LocalDate.of(2019,5,24));

        studentService.saveStudent(student1);
    }
}
