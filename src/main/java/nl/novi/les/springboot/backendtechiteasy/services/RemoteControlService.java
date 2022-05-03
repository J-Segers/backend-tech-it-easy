package nl.novi.les.springboot.backendtechiteasy.services;

import nl.novi.les.springboot.backendtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlInputDto;
import nl.novi.les.springboot.backendtechiteasy.models.entities.RemoteControl;
import nl.novi.les.springboot.backendtechiteasy.repositories.RemoteControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlDto.fromRemoteControl;
import static nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlInputDto.toRemoteControl;

@Service
public class RemoteControlService {

    private final RemoteControlRepository remoteControlRepository;

    @Autowired
    public RemoteControlService(RemoteControlRepository remoteControlRepository) {
        this.remoteControlRepository = remoteControlRepository;
    }

    public List<RemoteControlDto> getAllRemotes() {
        List<RemoteControl> remoteList = remoteControlRepository.findAll();

        return convertRemoteControlListToDtoList(remoteList);
    }

    public RemoteControlDto getSingleRemote(Long id) {
        Optional<RemoteControl> result = remoteControlRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("Remote not found");
        }

        RemoteControl remote = remoteControlRepository.getById(id);

        return fromRemoteControl(remote);
    }

    public RemoteControlDto addRemoteControl(RemoteControlInputDto remoteControlInputDto) {
        RemoteControl remoteControl = toRemoteControl(remoteControlInputDto);

        remoteControl = remoteControlRepository.save(remoteControl);

        return fromRemoteControl(remoteControl);
    }

    public RemoteControlDto updateRemoteControl(Long id, RemoteControlInputDto remoteControlInputDto) {
        Optional<RemoteControl> result = remoteControlRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("Remote does not exist!");
        }

        RemoteControl remoteControl = toRemoteControl(remoteControlInputDto);

        remoteControl.setId(id);

        remoteControl = remoteControlRepository.save(remoteControl);

        return fromRemoteControl(remoteControl);
    }

    public void deleteRemote(Long id) {
        Optional<RemoteControl> result = remoteControlRepository.findById(id);

        if(result.isEmpty()) {
            throw new RecordNotFoundException("Remote control does not exist!");
        }

        remoteControlRepository.deleteById(id);
    }

    private List<RemoteControlDto> convertRemoteControlListToDtoList(List<RemoteControl> remoteList) {
        List<RemoteControlDto> returnList = new ArrayList<>();

        for(RemoteControl remoteControl : remoteList) {
            returnList.add(fromRemoteControl(remoteControl));
        }

        return returnList;
    }
}
