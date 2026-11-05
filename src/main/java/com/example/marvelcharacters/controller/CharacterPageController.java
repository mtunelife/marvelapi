package com.example.marvelcharacters.controller;

import com.example.marvelcharacters.entity.MarvelCharacter;
import com.example.marvelcharacters.exception.CharacterNotFoundException;
import com.example.marvelcharacters.service.MarvelCharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Serves the HTML pages (FreeMarker templates).
 * It talks to the service layer only. It never calls the REST API or the repository.
 */
@Controller
public class CharacterPageController {

    private final MarvelCharacterService service;

    public CharacterPageController(MarvelCharacterService service) {
        this.service = service;
    }

    // ---------- Gallery + search ----------
    @GetMapping("/")
    public String gallery(@RequestParam(required = false) String name,
                          @RequestParam(required = false) String role,
                          Model model) {
        model.addAttribute("characters", service.getAll(name, role));
        model.addAttribute("roles", service.getAllRoles());
        model.addAttribute("name", name == null ? "" : name);
        model.addAttribute("role", role == null ? "" : role);
        return "index";
    }

    // ---------- Details ----------
    @GetMapping("/characters/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("character", service.getById(id));
        return "details";
    }

    // ---------- About ----------
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // ---------- Add ----------
    @GetMapping("/characters/new")
    public String newForm(Model model) {
        model.addAttribute("character", new MarvelCharacter());
        return form(model, new LinkedHashMap<>(), "/characters", "Add a New Character", "Add Character");
    }

    @PostMapping("/characters")
    public String create(@Valid @ModelAttribute("character") MarvelCharacter character,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return form(model, fieldErrors(result), "/characters", "Add a New Character", "Add Character");
        }
        MarvelCharacter saved = service.create(character);
        redirect.addFlashAttribute("flashMessage", saved.getName() + " was added");
        return "redirect:/"; // Post/Redirect/Get: refreshing will not resubmit the form
    }

    // ---------- Edit ----------
    @GetMapping("/characters/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("character", service.getById(id));
        return form(model, new LinkedHashMap<>(), "/characters/" + id, "Edit Character", "Save Changes");
    }

    @PostMapping("/characters/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("character") MarvelCharacter character,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {
        service.getById(id); // unknown id -> not-found page, even if the form is also invalid
        if (result.hasErrors()) {
            return form(model, fieldErrors(result), "/characters/" + id, "Edit Character", "Save Changes");
        }
        MarvelCharacter saved = service.update(id, character);
        redirect.addFlashAttribute("flashMessage", saved.getName() + " was updated");
        return "redirect:/characters/" + id;
    }

    // ---------- Delete ----------
    @PostMapping("/characters/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        MarvelCharacter existing = service.getById(id);
        String name = existing.getName();
        service.delete(id);
        redirect.addFlashAttribute("flashMessage", name + " was removed");
        return "redirect:/";
    }

    // ---------- Not found handling (HTML, not JSON) ----------
    @ExceptionHandler(CharacterNotFoundException.class)
    public ModelAndView handleNotFound(CharacterNotFoundException ex) {
        return notFoundPage("We couldn't find that character. It may have been removed.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleBadId(MethodArgumentTypeMismatchException ex) {
        return notFoundPage("That isn't a valid character ID.");
    }

    // ---------- Helpers ----------
    private ModelAndView notFoundPage(String message) {
        ModelAndView mav = new ModelAndView("error");
        mav.setStatus(HttpStatus.NOT_FOUND);
        mav.addObject("errorMessage", message);
        return mav;
    }

    private String form(Model model, Map<String, String> errors, String action, String title, String submitLabel) {
        model.addAttribute("errors", errors);
        model.addAttribute("formAction", action);
        model.addAttribute("formTitle", title);
        model.addAttribute("submitLabel", submitLabel);
        return "character-form";
    }

    private Map<String, String> fieldErrors(BindingResult result) {
        Map<String, String> errors = new LinkedHashMap<>();
        result.getFieldErrors().forEach(e -> errors.putIfAbsent(e.getField(), e.getDefaultMessage()));
        return errors;
    }
}
