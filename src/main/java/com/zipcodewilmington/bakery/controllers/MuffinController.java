package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    @Autowired // tell springBoot that we need to use same
    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/muffins/{id}")
    public ResponseEntity<Muffin> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping(value = "/muffins/")
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping(value = "/muffins/")
    public ResponseEntity<Muffin> update(@PathVariable("id)") Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping(value = "/muffins/")
    public ResponseEntity<Boolean> destroy(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
