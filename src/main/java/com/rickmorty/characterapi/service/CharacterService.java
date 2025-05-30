package com.rickmorty.characterapi.service;

import com.rickmorty.characterapi.dto.CharacterResponse;
import com.rickmorty.characterapi.dto.RickAndMortyClient;
import com.rickmorty.characterapi.dto.RickAndMortyResponse;
import com.rickmorty.characterapi.mapper.CharacterMapper;
import com.rickmorty.characterapi.repository.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rickmorty.characterapi.model.Character;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository repository;
    private final RickAndMortyClient client;

    public CharacterService(CharacterRepository repository, RickAndMortyClient client) {
        this.repository = repository;
        this.client = client;
    }
    public CharacterResponse getCharacters() {
        List<Character> stored = repository.findAll();
        if (!stored.isEmpty()) {
            return new CharacterResponse("characters fetched from the DB", stored);
        }

        var apiResponse = client.fetchCharacters();
        if (apiResponse == null || apiResponse.getResults() == null) {
            return new CharacterResponse("response not available from api", List.of());
        }

        List<Character> fresh = apiResponse.getResults()
                .stream()
                .map(CharacterMapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(fresh);
        return new CharacterResponse("characters fetched from the API", fresh);
    }

    public int deleteAllCharacters(){
        int total = (int) repository.count();
        repository.deleteAllInBatch();
        return total;
    }
}
