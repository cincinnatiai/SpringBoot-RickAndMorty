package com.rickmorty.characterapi.facade;

import com.rickmorty.characterapi.dto.CharacterResponse;
import com.rickmorty.characterapi.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterFacade {

    private final CharacterService characterService;

    public CharacterFacade(CharacterService characterService) {
        this.characterService = characterService;
    }

    public CharacterResponse getCharacters() {
        return characterService.getCharacters();
    }

    public int deleteAllCharacters(){
        return characterService.deleteAllCharacters();
    }
}
