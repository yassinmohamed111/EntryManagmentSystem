package org.example.entrymanagmentsystem.Mapper;

import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.DTO.Candidate.CandidateResponseDTO;
import org.example.entrymanagmentsystem.DTO.EducationDTO;
import org.example.entrymanagmentsystem.DTO.ExperienceDTO;
import org.example.entrymanagmentsystem.models.Candidate;
import org.example.entrymanagmentsystem.models.Education;
import org.example.entrymanagmentsystem.models.Experience;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateMapper {

    public Candidate mapperToEntity(CandidateRequestDTO candidateRequestDTO) {

            Candidate candidate = new Candidate();


            List<Education> educationList = new ArrayList<>();
            List<Experience> experienceList = new ArrayList<>();

            candidate.setAddress(candidateRequestDTO.getAddress());
            candidate.setEmail(candidateRequestDTO.getEmail());
            candidate.setDob(candidateRequestDTO.getDob());
            candidate.setGender(candidateRequestDTO.getGender());
            candidate.setMartial_status(candidateRequestDTO.getMartial_status());
            candidate.setPhone(candidateRequestDTO.getPhone());
            candidate.setName(candidateRequestDTO.getName());
            candidate.setPob(candidateRequestDTO.getPob());
            candidate.setMilitary_status(candidateRequestDTO.getMilitary_status());
            candidate.setSSN(candidateRequestDTO.getSSN());

                for(EducationDTO educationDto : candidateRequestDTO.getEducations()) {
                Education education = new Education();

                education.setGrade(educationDto.getGrade());
                education.setDate(educationDto.getDate());
                education.setCandidate(candidate);
                education.setMajor(educationDto.getMajor());
                education.setUniversity(educationDto.getUniversity());
                education.setDegree(educationDto.getDegree());
                educationList.add(education);

            }

            for(ExperienceDTO experienceDto : candidateRequestDTO.getExperiences()) {
                Experience experience = new Experience();

                experience.setCompany_name(experienceDto.getCompany_name());
                experience.setReason(experienceDto.getReason());
                experience.setCandidate(candidate);
                experience.setPostion(experienceDto.getPostion());
                experience.setEnd_date(experienceDto.getEnd_date());
                experience.setStart_date(experienceDto.getStart_date());
                experienceList.add(experience);

            }
            candidate.setEducations(educationList);
            candidate.setExperiences(experienceList);
            return candidate;
        }

        public CandidateResponseDTO entityToDTO(Candidate candidate) {
            CandidateResponseDTO candidateResponseDTO = new CandidateResponseDTO();
            candidateResponseDTO.setEmail(candidate.getEmail());
            candidateResponseDTO.setAddress(candidate.getAddress());
            candidateResponseDTO.setDob(candidate.getDob());
            candidateResponseDTO.setGender(candidate.getGender());
            candidateResponseDTO.setMartial_status(candidate.getMartial_status());
            candidateResponseDTO.setPhone(candidate.getPhone());
            candidateResponseDTO.setName(candidate.getName());
            candidateResponseDTO.setPob(candidate.getPob());
            candidateResponseDTO.setMilitary_status(candidate.getMilitary_status());
            candidateResponseDTO.setSSN(candidate.getSSN());
            return candidateResponseDTO;
        }

    }
}
