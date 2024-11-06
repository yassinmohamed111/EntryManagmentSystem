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

    private String dob;
    private String gender ;
    private String pob ;
    private String SSN ;
    private String address ;
    private String visitee;
    @Transient
    private String role;

    public Visitor(){
        this.role = "visitor";
    }


}
