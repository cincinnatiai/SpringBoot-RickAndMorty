package com.rickmorty.characterapi.controller;

import com.rickmorty.characterapi.dto.RickAndMortyResponse;
import com.rickmorty.characterapi.mapper.CharacterMapper;
import com.rickmorty.characterapi.repository.CharacterRepository;
import com.rickmorty.characterapi.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.rickmorty.characterapi.model.Character;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getCharacters(){
        return characterService.getCharacters();
    }

}
