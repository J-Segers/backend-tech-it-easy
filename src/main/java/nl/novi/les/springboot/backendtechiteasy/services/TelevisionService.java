package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.Television;
import nl.novi.les.springboot.backendtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

    public List<Television> getAllTvsOfBrand(String brand) {
        return televisionRepository.getAllTvsByBrand(brand);
    }

    public void addTv(Television newTv) {
        televisionRepository.save(newTv);
    }

    public void removeTv(long id) {
        televisionRepository.deleteById(id);
    }

}
