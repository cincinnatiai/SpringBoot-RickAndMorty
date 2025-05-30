package com.rickmorty.characterapi.mapper;
import com.rickmorty.characterapi.model.Character;
import com.rickmorty.characterapi.dto.CharacterDTO;

public class CharacterMapper {

    public static Character toEntity(CharacterDTO characterDTO) {
        return new Character(
                characterDTO.getId(),
                characterDTO.getName(),
                characterDTO.getStatus(),
                characterDTO.getSpecies(),
                characterDTO.getType(),
                characterDTO.getGender(),
                characterDTO.getOrigin() != null ? characterDTO.getOrigin().getName() : null,
                characterDTO.getLocation() != null ? characterDTO.getLocation().getName() : null,
                characterDTO.getImage()
        );
    }
}
