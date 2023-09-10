package de.amit.battlequest.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequest.user.model.Team;

public interface TeamRepository extends JpaRepository<Team, UUID> {

}
