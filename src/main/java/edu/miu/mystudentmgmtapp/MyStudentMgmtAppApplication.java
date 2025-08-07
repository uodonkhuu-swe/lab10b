package edu.miu.mystudentmgmtapp;

import edu.miu.mystudentmgmtapp.model.Classroom;
import edu.miu.mystudentmgmtapp.model.Course;
import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.model.Transcript;
import edu.miu.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.mystudentmgmtapp.service.ClassroomService;
import edu.miu.mystudentmgmtapp.service.CourseService;
import edu.miu.mystudentmgmtapp.service.StudentService;
import edu.miu.mystudentmgmtapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    private final StudentService studentService;
    private final TranscriptService transcriptService;
    private final CourseService courseService;
    private final ClassroomService classroomService;

    @Autowired
    public MyStudentMgmtAppApplication(StudentService studentService, TranscriptService transcriptService, CourseService courseService, ClassroomService classroomService) {
        this.studentService = studentService;
        this.transcriptService = transcriptService;
        this.courseService = courseService;
        this.classroomService = classroomService;
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

        var transcript1 = new Transcript();
        transcript1.setDegreeTitle("BS Computer Science");
        student1.setTranscript(transcript1);

        var result = studentService.saveStudent(student1);

        System.out.println(result);
    }
}
