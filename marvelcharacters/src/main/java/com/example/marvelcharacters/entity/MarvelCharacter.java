package com.example.marvelcharacters.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "characters")
public class MarvelCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    @NotBlank(message = "name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "description is required")
    @Column(nullable = false, length = 1000)
    private String description;

    private String species;

    private String role;

    public MarvelCharacter() {
    }

    public MarvelCharacter(String name, String description, String species, String role) {
        this.name = name;
        this.description = description;
        this.species = species;
        this.role = role;
    }

    public Long getCharacterId() { return characterId; }
    public void setCharacterId(Long characterId) { this.characterId = characterId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
