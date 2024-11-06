package org.example.entrymanagmentsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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
@Entity

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String university;
    private String degree ;
    private String grade ;
    private String major ;
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    @JsonBackReference("CandidateEduReference")
    private Candidate candidate;
}
