package edu.miu.mystudentmgmtapp.repository;

import edu.miu.mystudentmgmtapp.model.Student;
import edu.miu.mystudentmgmtapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
