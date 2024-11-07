package org.example.entrymanagmentsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class EntryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate Date;


    public EntryLog()
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
