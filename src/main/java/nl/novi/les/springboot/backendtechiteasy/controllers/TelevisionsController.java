package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {

    private TelevisionService televisionService;

    @Autowired
    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTvs() {

        return ResponseEntity.ok("Hello, World!");

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getTvById() {

        return ResponseEntity.ok("Goodbye cruel world!");

    }

    @PostMapping
    public ResponseEntity<Object> addTv(@RequestBody Object newTv) {

        return ResponseEntity.created();

    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> removeTv(@PathVariable Long id) {

        return ResponseEntity.noContent();

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
