package com.example.marvelapi.entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/characters")
public class CharacterUIController {

    public CharacterUIController(CharacterUIController service) {
        this.service = service;
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
  @GetMapping("/{id}")
  public String details(@PathVariable long id) {
    Character character = service.getById(id);
    return "details";
  }

}