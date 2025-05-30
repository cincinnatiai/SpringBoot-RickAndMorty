package com.rickmorty.characterapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rickmorty.characterapi.model.Character;


public interface CharacterRepository extends JpaRepository<Character, Long> {

}
