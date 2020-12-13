package fr.istv.bug_tracking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istv.bug_tracking.models.Developper;

public interface DevelopperRepository extends JpaRepository<Developper, Integer> {
    Optional<Developper> findById(Integer id);
}
