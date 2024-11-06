package org.example.entrymanagmentsystem.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entrymanagmentsystem.DTO.EducationDTO;
import org.example.entrymanagmentsystem.DTO.ExperienceDTO;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {
    private String university;
    private String degree ;
    private String grade ;
    private String major ;
    private LocalDate date;
}
