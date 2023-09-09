package de.amit.battlequest.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequest.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	public User findByUsername(String username);
}