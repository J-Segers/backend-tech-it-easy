package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionCreatedDto;
import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;
import nl.novi.les.springboot.backendtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTvs() {
        return televisionRepository.findAll();
    }

    public TelevisionCreatedDto getTvById(Long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }

        Television tv = televisionRepository.getById(id);
        TelevisionCreatedDto tvDto = new TelevisionCreatedDto();
        tvDto.setId(tv.getId());
        tvDto.setType(tv.getType());
        tvDto.setBrand(tv.getBrand());
        tvDto.setName(tv.getName());
        tvDto.setPrice(tv.getPrice());

        return tvDto;
    }

    public TelevisionCreatedDto addTv(TelevisionDto newTv) {

        Television tv = new Television();

        tv.setType(newTv.getType());
        tv.setBrand(newTv.getBrand());
        tv.setName(newTv.getName());
        tv.setPrice(newTv.getPrice());

        tv = televisionRepository.save(tv);

        TelevisionCreatedDto createdTelevision = new TelevisionCreatedDto();

        createdTelevision.setId(tv.getId());
        createdTelevision.setType(tv.getType());
        createdTelevision.setBrand(tv.getBrand());
        createdTelevision.setName(tv.getName());
        createdTelevision.setPrice(tv.getPrice());

        return createdTelevision;
    }

    public Television updateTv(long id, Television tv) {

        Optional<Television> result = televisionRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("tv cannot be found!");
        }

        return televisionRepository.save(tv);
    }

    public void removeTv(long id) {
        televisionRepository.deleteById(id);
    }

    public List<Television> getAllTvsByType(String value) {
        return televisionRepository.findTelevisionsByTypeEqualsIgnoreCase(value);
    }

    public List<Television> getAllTvsByBrand(String value) {
        return televisionRepository.findTelevisionsByBrandEqualsIgnoreCase(value);
    }

    public List<Television> getAllTvsByName(String value) {
        return televisionRepository.findTelevisionsByNameEqualsIgnoreCase(value);
    }

    public List<Television> getAllTvsByPrice(double value) {
        return televisionRepository.findTelevisionsByPriceIs(value);
    }

}
