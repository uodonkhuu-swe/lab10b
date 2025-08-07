package edu.miu.mystudentmgmtapp.repository;

import edu.miu.mystudentmgmtapp.model.Classroom;
import edu.miu.mystudentmgmtapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
