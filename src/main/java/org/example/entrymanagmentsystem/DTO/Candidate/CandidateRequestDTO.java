package org.example.entrymanagmentsystem.DTO.Candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entrymanagmentsystem.DTO.EducationDTO;
import org.example.entrymanagmentsystem.DTO.ExperienceDTO;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequestDTO {
    private String name ;
    private String email ;
    private String phone ;
    private String dob;
    private String gender ;
    private String pob ;
    private String military_status ;
    private String SSN ;
    private String address ;
    private String martial_status ;
    private List<EducationDTO> educations ;
    private List<ExperienceDTO> experiences ;
}
