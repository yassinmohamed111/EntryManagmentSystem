package org.example.entrymanagmentsystem.DTO.Visitor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorRequestDTO {
    @NotBlank(message = "Name  is required!")
    String name;
    @NotBlank(message = "Phone is required!")
    String phone;
    @NotBlank(message = "DOB is required!")
    String dob;
    @NotBlank(message = "Gender is required!")
    String gender;
    @NotBlank(message = "POB is required!")
    String pob;
    @NotBlank(message = "SSN is required!")
    String SSN;
    @NotBlank(message = "Address is required!")
    String address;
    @NotBlank(message = "Visitee is required!")
    String visitee;
}
