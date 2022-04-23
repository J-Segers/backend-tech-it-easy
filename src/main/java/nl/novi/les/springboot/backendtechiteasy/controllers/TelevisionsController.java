package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.Television;
import nl.novi.les.springboot.backendtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {

    private TelevisionService televisionService;

    @Autowired
    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTvs() {

        return ResponseEntity.ok(televisionService.getAllTvs());

    }

    @GetMapping("{id}")
    public ResponseEntity<Television> getTvById(@PathVariable Long id) {

        return ResponseEntity.ok(televisionService.getTvById(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTv(@RequestBody Television newTv) {

        televisionService.addTv(newTv);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeTv(@PathVariable Long id) {

        televisionService.removeTv(id);

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateTv(@PathVariable Long id, @RequestBody Object tv) {

        return ResponseEntity.noContent();

    }

    @GetMapping("?branch={branch}")
    public ResponseEntity<Object> getAllTvsOfBrand(@RequestParam String brand) {

        return ResponseEntity.ok();

    }

}
