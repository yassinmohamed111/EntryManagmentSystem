package org.example.entrymanagmentsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate Date;


    public Attendance()
    {
        this.Date= LocalDate.now();

    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "a_id")
//    @JsonBackReference("VisitorReference")
//    private Visitor visitor;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "a_id")
//    @JsonBackReference("VisitorReference")
//    private Candidate candidate;
    private long person_id ;
    private String role ;


}
