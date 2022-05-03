package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleDto;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleInputDto;
import nl.novi.les.springboot.backendtechiteasy.models.entities.CIModule;
import nl.novi.les.springboot.backendtechiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleDto.fromCIModule;
import static nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleInputDto.toCIModule;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleDto> getAllCIModules() {
        return convertCIModuleListToDtoList(ciModuleRepository.findAll());
    }

    public CIModuleDto getSingleCIModule(Long id) {
        checkIfCIModuleExists(id);

        return fromCIModule(ciModuleRepository.getById(id));
    }

    public CIModuleDto addCIModule(CIModuleInputDto inputDto) {
        CIModule newModule = toCIModule(inputDto);

        newModule = ciModuleRepository.save(newModule);

        return fromCIModule(newModule);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleInputDto inputDto) {
        checkIfCIModuleExists(id);

        CIModule updatedModule = toCIModule(inputDto);
        updatedModule.setId(id);

        updatedModule = ciModuleRepository.save(updatedModule);

        return fromCIModule(updatedModule);
    }

    public void removeCIModule(Long id) {
        checkIfCIModuleExists(id);

        ciModuleRepository.deleteById(id);
    }

    private void checkIfCIModuleExists(Long id) {
        Optional<CIModule> result = ciModuleRepository.findById(id);
        if(result.isEmpty()) {
            throw new RecordNotFoundException("CIModule does not exist!");
        }
    }

    private List<CIModuleDto> convertCIModuleListToDtoList(List<CIModule> list) {
        List<CIModuleDto> convertedList = new ArrayList<>();

        for(CIModule module : list) {
            convertedList.add(fromCIModule(module));
        }

        return convertedList;
    }

}
