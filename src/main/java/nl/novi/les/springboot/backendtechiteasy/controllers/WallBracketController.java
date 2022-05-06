package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.WallBracketInputDto;
import nl.novi.les.springboot.backendtechiteasy.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    @Autowired
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }

    @GetMapping("{id}")
    public ResponseEntity<WallBracketDto> getSingleWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getSingleWallBracket(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> addNewWallBracket(@RequestBody WallBracketInputDto inputDto) {
        WallBracketDto result = wallBracketService.addWallBracket(inputDto);

        URI location = URI.create("wallbrackets/" + result.id);

        return ResponseEntity.created(location).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, WallBracketInputDto inputDto) {
        return ResponseEntity.accepted().body(wallBracketService.updateWallBracket(id, inputDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> removeWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
