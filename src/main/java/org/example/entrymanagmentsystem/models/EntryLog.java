package org.example.entrymanagmentsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class EntryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate Date;
    private LocalTime Time;



    public EntryLog()
    {
        this.Date= LocalDate.now();
        this.Time= LocalTime.now();

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
