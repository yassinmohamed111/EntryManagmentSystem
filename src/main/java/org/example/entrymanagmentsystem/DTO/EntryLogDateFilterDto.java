package org.example.entrymanagmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryLogDateFilterDto {
    LocalDate startDate ;
    LocalDate endDate ;

}
