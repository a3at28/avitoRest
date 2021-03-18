package tech.itpark.avito.controller;

import org.springframework.web.bind.annotation.*;
import tech.itpark.avito.domain.Flat;
import tech.itpark.avito.domain.FlatCreat;
import tech.itpark.avito.domain.FlatUpdate;
import tech.itpark.avito.manager.FlatManager;

import java.util.ArrayList;

@RestController
public class FlatController {
    private FlatManager manager = new FlatManager();

    @GetMapping("/flats")
    public ArrayList<Flat> getAll() { return manager.getAll(); }


    @GetMapping("/flats/search")
    public ArrayList<Flat> searchBy(@RequestParam String address) {
        return manager.searchBy(address);
    }

    @GetMapping("/flats/filter")
    public ArrayList<Flat> searchByMinMaxPrice(@RequestParam int MinPrice, @RequestParam int MaxPrice) {
        return manager.searchByMinMaxPrice(MinPrice, MaxPrice);
    }

    @GetMapping("flats/{id}")
    public Flat getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping("/flats")
    public Flat create(@RequestBody FlatCreat dto) {
        return manager.register(dto);
    }

    @PutMapping("/flats/{id}")
    public Flat updateById(@PathVariable long id, @RequestBody FlatUpdate dto) {
        return manager.updateById(id, dto);
    }

    @DeleteMapping("/flats/{id}")
    public void removeById(@PathVariable long id) {
        manager.removedById(id);
    }

}
