package edu.miu.mystudentmgmtapp.dto;

import edu.miu.mystudentmgmtapp.model.Student;

import java.time.LocalDate;

public record StudentResponseDTO(
        Integer id,
        String studentNumber,
        String firstName,
        String middleName,
        String lastName,
        Double cgpa,
        LocalDate dateOfEnrollment,
        TranscriptResponseDTO transcript
) {
}
