package org.example.entrymanagmentsystem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryLogDTO {
    @NotBlank(message = "NID cannot be blank")
    @Pattern(regexp = "^.{14}$", message = "The field must contain exactly 14 characters.")
    String nid ;
}

