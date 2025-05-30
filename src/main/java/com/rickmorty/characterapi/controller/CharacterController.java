package com.rickmorty.characterapi.controller;

import com.rickmorty.characterapi.dto.CharacterResponse;
import com.rickmorty.characterapi.facade.CharacterFacade;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterFacade facade;

    public CharacterController(CharacterFacade facade) {
        this.facade = facade;
    }

    @Timed(value = "character.get.all", description = "Time taken to get all characters")
    @GetMapping
    public CharacterResponse getCharacters() {
        return facade.getCharacters();
    }

    @Timed(value = "character.delete.all", description = "Time taken to delete all characters")
    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteCharacters(){
        int deleted = facade.deleteAllCharacters();
        return ResponseEntity.ok(Map.of(
                "deletedCount", deleted,
                "message", "deleted all characters"
        ));
    }
}