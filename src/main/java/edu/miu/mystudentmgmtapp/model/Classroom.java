package edu.miu.mystudentmgmtapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    private Integer id;
    private String buildingName;
    private String roomNumber;

    @OneToMany
    private List<Student> student;
}
