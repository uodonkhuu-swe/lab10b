package edu.miu.mystudentmgmtapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDate;
import java.util.List;

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
    private Integer id;
    @Column(name = "student_number", nullable = false, length = 50, unique = true)
    private String studentNumber;
    private String firstName;
    private String middleName;

    private String lastName;
    private Double cgpa;

    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = true)
    private Transcript transcript;

    @ManyToOne
    private Classroom classroom;

    @ManyToMany
    private List<Course> courses;
}
