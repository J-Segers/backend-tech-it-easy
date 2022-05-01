package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionInputDto;
import nl.novi.les.springboot.backendtechiteasy.models.dtos.TelevisionDto;
import nl.novi.les.springboot.backendtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {

    private final TelevisionService televisionService;

    @Autowired
    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTvs(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Double price) {

        List<TelevisionDto> televisions;

        if(type != null){
            televisions = televisionService.getAllTvsByType(type);
        }else if(brand != null){
            televisions = televisionService.getAllTvsByBrand(brand);
        }else if(name != null){
            televisions = televisionService.getAllTvsByName(name);
        }else if(price != null){
            televisions = televisionService.getAllTvsByPrice(price);
        } else {
            televisions = televisionService.getAllTvs();
        }

        return ResponseEntity.ok(televisions);
    }

    @GetMapping("{id}")
    public ResponseEntity<TelevisionDto> getTvById(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTvById(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTv(@RequestBody TelevisionInputDto newTv) {
        TelevisionDto createdTv = televisionService.addTv(newTv);

        URI location = URI.create("televisions/" + createdTv.id);

        return ResponseEntity.created(location).body(createdTv);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> removeTv(@PathVariable Long id) {
        televisionService.removeTv(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TelevisionDto> updateTv(@PathVariable Long id, @RequestBody TelevisionInputDto tv) {

        return ResponseEntity.accepted().body(televisionService.updateTv(id, tv));
    }

}
