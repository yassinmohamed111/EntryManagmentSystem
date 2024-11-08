package org.example.entrymanagmentsystem.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class Candidate {
    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String email ;
    private String phone ;
    private String dob;
    private String gender ;
    private String pob ;
    private String military_status ;
    private String ssn ;
    private String address ;
    private String martial_status ;
    @Transient
    private  String role;

    public Candidate()
    {
        this.role = "candidate";
    }


    @OneToMany(mappedBy = "candidate"  , cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST , CascadeType.REFRESH})

    @JsonManagedReference("userDetailsEduReference")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "candidate"  , cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST , CascadeType.REFRESH})
    @JsonManagedReference("userDetailsExpReference")
    private List<Experience> experiences = new ArrayList<>();

}
