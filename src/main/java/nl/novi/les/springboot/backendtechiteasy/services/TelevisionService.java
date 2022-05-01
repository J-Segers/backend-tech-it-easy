package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionInputDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionDto;
import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;
import nl.novi.les.springboot.backendtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionDto.fromTelevision;
import static nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionInputDto.toTelevision;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTvs() {
        List<Television> televisionList = televisionRepository.findAll();

        return convertTelevisionListToDtoList(televisionList);
    }

    public TelevisionDto getTvById(Long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }

        Television tv = televisionRepository.getById(id);

        return fromTelevision(tv);
    }

    public TelevisionDto addTv(TelevisionInputDto newTv) {

        Television tv = toTelevision(newTv);

        tv = televisionRepository.save(tv);

        return fromTelevision(tv);
    }

    public TelevisionDto updateTv(long id, TelevisionInputDto tv) {

        Optional<Television> result = televisionRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("tv cannot be found!");
        }

        Television updatedTv = toTelevision(tv);
        updatedTv.setId(id);
        updatedTv = televisionRepository.save(updatedTv);

        return fromTelevision(updatedTv);
    }

    public void removeTv(long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }
        televisionRepository.deleteById(id);
    }

    public List<TelevisionDto> getAllTvsByType(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByTypeEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionDto> getAllTvsByBrand(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByBrandEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionDto> getAllTvsByName(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByNameEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionDto> getAllTvsByPrice(double value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByPriceIs(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    private List<TelevisionDto> convertTelevisionListToDtoList(List<Television> televisionList) {
        List<TelevisionDto> returnList = new ArrayList<>();

        for(Television tv : televisionList) {
            returnList.add(fromTelevision(tv));
        }

        return returnList;
    }

}
