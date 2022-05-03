package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.RemoteControlInputDto;
import nl.novi.les.springboot.backendtechiteasy.services.RemoteControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("remote-controllers")
public class RemoteControlController {

    private final RemoteControlService remoteControlService;

    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControlDto>> getAllRemotes() {
        return ResponseEntity.ok(remoteControlService.getAllRemotes());
    }

    @GetMapping("{id}")
    public ResponseEntity<RemoteControlDto> getSingleRemote(@PathVariable Long id) {
        return ResponseEntity.ok(remoteControlService.getSingleRemote(id));
    }

    @PostMapping
    public ResponseEntity<RemoteControlDto> addRemote(@RequestBody RemoteControlInputDto inputDto) {
        RemoteControlDto outputDto = remoteControlService.addRemoteControl(inputDto);

        URI location = URI.create("remote-controllers" + outputDto.id);

        return ResponseEntity.created(location).body(outputDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<RemoteControlDto> updateRemote(@PathVariable Long id, @RequestBody RemoteControlInputDto inputDto) {
        return ResponseEntity.accepted().body(remoteControlService.updateRemoteControl(id, inputDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpResponse.ResponseInfo> removeRemote(@PathVariable Long id) {
        remoteControlService.deleteRemote(id);

        return ResponseEntity.noContent().build();
    }

}
