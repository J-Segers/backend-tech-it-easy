package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.Television;
import nl.novi.les.springboot.backendtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTvs() {
        return televisionRepository.findAll();
    }

    public Television getTvById(Long id) {
        Optional<Television> result = televisionRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("Tv not found!");
        }

        return televisionRepository.getById(id);
    }

    public void addTv(Television newTv) {
        televisionRepository.save(newTv);
    }

    public void updateTv(long id, Television tv) {

        Optional<Television> result = televisionRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("tv cannot be found!");
        }

        Television tvToUpdate = televisionRepository.getById(id);

        tvToUpdate.setPrice(tv.getPrice());

        televisionRepository.save(tvToUpdate);


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
