package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.Admin;
import org.example.entrymanagmentsystem.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepo extends JpaRepository<Visitor, Long> {
    boolean existsVisitorBySSN(String ssn);
    Visitor findVisitorBySSN(String ssn);
    Optional<Visitor> findBySSN(String email);
}
