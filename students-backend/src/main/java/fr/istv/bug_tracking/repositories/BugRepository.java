package fr.istv.bug_tracking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istv.bug_tracking.models.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer> {
    Optional<Bug> findById(Integer id);
}
