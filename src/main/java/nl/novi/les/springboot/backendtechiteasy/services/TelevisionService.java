package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionCreatedDto;
import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;
import nl.novi.les.springboot.backendtechiteasy.repositories.TelevisionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionCreatedDto> getAllTvs() {
        List<Television> televisionList = televisionRepository.findAll();

        return convertTelevisionListToDtoList(televisionList);
    }

    public TelevisionCreatedDto getTvById(Long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }

        Television tv = televisionRepository.getById(id);

        return modelMapper.map(tv, TelevisionCreatedDto.class);
    }

    public TelevisionCreatedDto addTv(TelevisionDto newTv) {

        Television tv = modelMapper.map(newTv, Television.class);

        tv = televisionRepository.save(tv);

        return modelMapper.map(tv, TelevisionCreatedDto.class);
    }

    public TelevisionCreatedDto updateTv(long id, TelevisionCreatedDto tv) {

        Optional<Television> result = televisionRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("tv cannot be found!");
        }

        Television updatedTv = modelMapper.map(tv, Television.class);

        updatedTv = televisionRepository.save(updatedTv);

        return modelMapper.map(updatedTv, TelevisionCreatedDto.class);
    }

    public void removeTv(long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }
        televisionRepository.deleteById(id);
    }

    public List<TelevisionCreatedDto> getAllTvsByType(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByTypeEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionCreatedDto> getAllTvsByBrand(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByBrandEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionCreatedDto> getAllTvsByName(String value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByNameEqualsIgnoreCase(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    public List<TelevisionCreatedDto> getAllTvsByPrice(double value) {
        List<Television> televisionList = televisionRepository.findTelevisionsByPriceIs(value);

        return convertTelevisionListToDtoList(televisionList);
    }

    private List<TelevisionCreatedDto> convertTelevisionListToDtoList(List<Television> televisionList) {
        List<TelevisionCreatedDto> returnList = new ArrayList<>();

        for(Television tv : televisionList) {
            returnList.add(modelMapper.map(tv, TelevisionCreatedDto.class));
        }

        return returnList;
    }

}
