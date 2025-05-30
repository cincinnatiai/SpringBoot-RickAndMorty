package com.rickmorty.characterapi.service;

import com.rickmorty.characterapi.dto.RickAndMortyClient;
import com.rickmorty.characterapi.dto.RickAndMortyResponse;
import com.rickmorty.characterapi.mapper.CharacterMapper;
import com.rickmorty.characterapi.repository.CharacterRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rickmorty.characterapi.model.Character;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    //private static final Logger log = LoggerFactory.getLogger(CharacterService.class);

    private final CharacterRepository repository;
    private final RickAndMortyClient client;

    public CharacterService(CharacterRepository repository, RickAndMortyClient client) {
        this.repository = repository;
        this.client = client;
    }

    public List<Character> getCharacters() {
        List<Character> stored = repository.findAll();
        if (!stored.isEmpty()) {
            //log.info("characters fetched from the DB");
            System.out.println("characters fetched from the DB");
            return stored;
        }

        RickAndMortyResponse apiResponse = client.fetchCharacters();
        if (apiResponse == null || apiResponse.getResults() == null) {
            //log.info("remote API returned no data");
            System.out.println("failed trying to get characters from api");
            return List.of();
        }

        List<Character> fresh = apiResponse.getResults()
                .stream()
                .map(CharacterMapper::toEntity)
                .collect(Collectors.toList());

        repository.saveAll(fresh);
        //log.info("characters fetched from the API");
        System.out.println("characters fetched from the api");
        return fresh;
    }
}
