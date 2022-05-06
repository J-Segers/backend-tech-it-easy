package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketInputDto;
import nl.novi.les.springboot.backendtechiteasy.models.entities.WallBracket;
import nl.novi.les.springboot.backendtechiteasy.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketDto.fromWallBracket;
import static nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketInputDto.toWallBracket;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        return convertWallBracketListToDtoList(wallBracketRepository.findAll());
    }

    public WallBracketDto getSingleWallBracket(Long id) {
        return fromWallBracket(wallBracketRepository.getById(id));
    }

    public WallBracketDto addWallBracket(WallBracketInputDto inputDto) {
        WallBracket newBracket = toWallBracket(inputDto);

        newBracket = wallBracketRepository.save(newBracket);

        return fromWallBracket(newBracket);
    }

    public  WallBracketDto updateWallBracket(Long id, WallBracketInputDto inputDto) {
        Optional<WallBracket> result = wallBracketRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("This wall bracket does not exist!");
        }

        WallBracket wallBracketToUpdate = toWallBracket(inputDto);

        wallBracketToUpdate.setId(id);
        wallBracketToUpdate = wallBracketRepository.save(wallBracketToUpdate);

        return fromWallBracket(wallBracketToUpdate);
    }

    public void deleteWallBracket(Long id) {
        Optional<WallBracket> result = wallBracketRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("This wall bracket already does not exist!");
        }
    }

    private List<WallBracketDto> convertWallBracketListToDtoList(List<WallBracket> list) {
        List<WallBracketDto> convertedList = new ArrayList<>();

        for(WallBracket bracket : list) {
            convertedList.add(fromWallBracket(bracket));
        }

        return convertedList;
    }
}
