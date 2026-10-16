package com.example.marvelcharacters.repository;

import com.example.marvelcharacters.entity.MarvelCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarvelCharacterRepository extends JpaRepository<MarvelCharacter, Long> {

    // Filter by role (exact match, case-insensitive)
    List<MarvelCharacter> findByRoleIgnoreCase(String role);

    // Search by name (partial, case-insensitive)
    List<MarvelCharacter> findByNameContainingIgnoreCase(String name);

    // Search by name AND role together
    List<MarvelCharacter> findByNameContainingIgnoreCaseAndRoleIgnoreCase(String name, String role);
}
