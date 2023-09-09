package de.amit.battlequestOLD.controller.rest.session;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequestOLD.model.Session;

public interface SessionRepository extends JpaRepository<Session, String> {
}