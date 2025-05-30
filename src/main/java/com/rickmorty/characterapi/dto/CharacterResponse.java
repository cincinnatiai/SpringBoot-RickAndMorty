package com.rickmorty.characterapi.dto;

import com.rickmorty.characterapi.model.Character;

import java.util.List;

public class CharacterResponse {

    private final String source;

    private final List<Character> characters;

    public CharacterResponse(String source, List<Character> characters) {
        this.source      = source;
        this.characters  = characters;
    }

    public String getSource() {
        return source;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}

