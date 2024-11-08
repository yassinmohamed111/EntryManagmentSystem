package org.example.entrymanagmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EntryLogResponseDTO {
    String name ;
    long person_id ;
    String role ;
    String ssn ;
    LocalDate date ;
    LocalTime time ;
    String phoneNumber ;
}
