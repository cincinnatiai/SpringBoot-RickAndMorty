package com.rickmorty.characterapi.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RickAndMortyClient {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";
    private final RestTemplate restTemplate = new RestTemplate();

    public RickAndMortyResponse fetchCharacters(){
        return restTemplate.getForObject(BASE_URL, RickAndMortyResponse.class);
    }
}
