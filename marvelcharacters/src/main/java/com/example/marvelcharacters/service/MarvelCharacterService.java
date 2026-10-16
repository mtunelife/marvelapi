package com.example.marvelcharacters.service;

import com.example.marvelcharacters.entity.MarvelCharacter;
import com.example.marvelcharacters.exception.CharacterNotFoundException;
import com.example.marvelcharacters.repository.MarvelCharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarvelCharacterService {

    private final MarvelCharacterRepository repository;

    public MarvelCharacterService(MarvelCharacterRepository repository) {
        this.repository = repository;
    }

    public List<MarvelCharacter> getAll(String name, String role) {
        boolean hasName = name != null && !name.isBlank();
        boolean hasRole = role != null && !role.isBlank();

        if (hasName && hasRole) {
            return repository.findByNameContainingIgnoreCaseAndRoleIgnoreCase(name.trim(), role.trim());
        }
        if (hasName) {
            return repository.findByNameContainingIgnoreCase(name.trim());
        }
        if (hasRole) {
            return repository.findByRoleIgnoreCase(role.trim());
        }
        return repository.findAll();
    }

    public MarvelCharacter getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    public MarvelCharacter create(MarvelCharacter character) {
        character.setCharacterId(null); // make sure the ID is always auto-generated
        return repository.save(character);
    }

    public MarvelCharacter update(Long id, MarvelCharacter updated) {
        MarvelCharacter existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setSpecies(updated.getSpecies());
        existing.setRole(updated.getRole());
        return repository.save(existing);
    }

    public void delete(Long id) {
        MarvelCharacter existing = getById(id);
        repository.delete(existing);
    }
}
