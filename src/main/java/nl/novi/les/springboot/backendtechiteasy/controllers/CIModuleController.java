package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.CIModuleInputDto;
import nl.novi.les.springboot.backendtechiteasy.services.CIModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("ci-modules")
public class CIModuleController {

    private final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity<List<CIModuleDto>> getAllCIModules() {
        return ResponseEntity.ok(ciModuleService.getAllCIModules());
    }

    @GetMapping("{id}")
    public ResponseEntity<CIModuleDto> getSingleCIModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getSingleCIModule(id));
    }

    @PostMapping
    public ResponseEntity<CIModuleDto> addNewCIModule(@RequestBody CIModuleInputDto inputDto) {
        CIModuleDto ciModuleDto = ciModuleService.addCIModule(inputDto);

        URI location = URI.create("ci-modules/" + ciModuleDto.id);

        return ResponseEntity.created(location).body(ciModuleDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CIModuleDto> updateCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto inputDto) {
        return ResponseEntity.accepted().body(ciModuleService.updateCIModule(id, inputDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> removeCIModule(@PathVariable Long id) {
        ciModuleService.removeCIModule(id);

        return ResponseEntity.noContent().build();
    }

}
