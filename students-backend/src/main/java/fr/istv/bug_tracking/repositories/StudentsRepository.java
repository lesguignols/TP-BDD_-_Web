package fr.istv.bug_tracking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istv.bug_tracking.models.Student;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    //Optional<Student> findById(Integer id);
}
