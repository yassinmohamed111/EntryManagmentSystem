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
public class ExperienceDTO {
    private String postion;
    private String reason;
    private String company_name;
    private LocalDate start_date;
    private LocalDate end_date;
}
