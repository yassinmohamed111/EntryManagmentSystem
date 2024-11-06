package org.example.entrymanagmentsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "Invalid email address")
    private String email;
    @Pattern(
            regexp = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$",
            message = "Password must be at least 8 characters long, include an uppercase letter, a lowercase letter, a number, and a special character."
    )
    private String password;
    private String user_name;
}