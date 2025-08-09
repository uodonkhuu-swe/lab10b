package edu.miu.mystudentmgmtapp.dto;

import java.time.LocalDate;

public record StudentRequestDTO(
        String studentNumber,
        String firstName,
        String middleName,
        String lastName,
        Double cgpa,
        LocalDate dateOfEnrollment,
        TranscriptRequestDTO transcript
) {
}
