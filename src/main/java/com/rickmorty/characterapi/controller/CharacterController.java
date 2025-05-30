package com.rickmorty.characterapi.controller;

import com.rickmorty.characterapi.dto.CharacterResponse;
import com.rickmorty.characterapi.facade.CharacterFacade;

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

    @GetMapping
    public CharacterResponse getCharacters() {
        return facade.getCharacters();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteCharacters(){
        int deleted = facade.deleteAllCharacters();
        return ResponseEntity.ok(Map.of(
                "deletedCount", deleted,
                "message", "deleted all characters"

        ));
    }
}