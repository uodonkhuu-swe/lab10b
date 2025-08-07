package edu.miu.mystudentmgmtapp.repository;

import edu.miu.mystudentmgmtapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
