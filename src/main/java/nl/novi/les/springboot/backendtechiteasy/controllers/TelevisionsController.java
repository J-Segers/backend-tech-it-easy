package nl.novi.les.springboot.backendtechiteasy.controllers;

import nl.novi.les.springboot.backendtechiteasy.models.Television;
import nl.novi.les.springboot.backendtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Television>> getAllTvs(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Double price) {

        List<Television> televisions;

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
    @ResponseStatus(HttpStatus.OK)
    public void updateTv(@PathVariable Long id, @RequestBody Television tv) {
        televisionService.updateTv(id, tv);
    }

}
