package org.example.entrymanagmentsystem.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Visitor {
    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;

    private String phone ;

    @NotBlank(message = "dob cannot be blank")
    private String dob;

    @NotBlank(message = "Gender cannot be blank")
    private String gender ;
    @NotBlank(message = "pob cannot be blank")
    private String pob ;
    private String SSN ;
    @NotBlank(message = "address cannot be blank")
    private String address ;
    private String visitee;
    private String role;

    public Visitor(){
        this.role = "visitor";
    }


}
