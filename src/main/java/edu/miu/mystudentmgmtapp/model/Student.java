package edu.miu.mystudentmgmtapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column(name = "student_number", nullable = false, length = 50, unique = true)
    private String studentNumber;
    private String firstName;
    private String middleName;

    private String lastName;
    private Double cgpa;

    private LocalDate dateOfEnrollment;
}
