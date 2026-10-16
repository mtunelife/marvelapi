package com.example.marvelcharacters.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Long id) {
        super("Character not found with id " + id);
    }
}
