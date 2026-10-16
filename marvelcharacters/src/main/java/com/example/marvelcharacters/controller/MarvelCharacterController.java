package com.example.marvelcharacters.controller;

import com.example.marvelcharacters.entity.MarvelCharacter;
import com.example.marvelcharacters.service.MarvelCharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class MarvelCharacterController {

    private final MarvelCharacterService service;

    public MarvelCharacterController(MarvelCharacterService service) {
        this.service = service;
    }

    // GET /api/characters, ?role=Hero, ?name=spi
    @GetMapping
    public List<MarvelCharacter> getAll(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String role) {
        return service.getAll(name, role);
    }

    @GetMapping("/{id}")
    public MarvelCharacter getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarvelCharacter create(@Valid @RequestBody MarvelCharacter character) {
        return service.create(character);
    }

    @PutMapping("/{id}")
    public MarvelCharacter update(@PathVariable Long id, @Valid @RequestBody MarvelCharacter character) {
        return service.update(id, character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
