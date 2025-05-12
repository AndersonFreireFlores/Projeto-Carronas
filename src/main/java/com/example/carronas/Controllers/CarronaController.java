package com.example.carronas.Controllers;

import com.example.carronas.Models.Carrona;
import com.example.carronas.Models.DTOs.CarronaDto;
import com.example.carronas.Services.CarronaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CarronaController {

    private final CarronaService service;

    public CarronaController(CarronaService service) {
        this.service = service;
    }

    @GetMapping(path = "/carronas")
    public List<CarronaDto> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/carronas/{id}")
    public CarronaDto getById(UUID id) {
        return service.getById(id);
    }

    @PostMapping(path = "/carronas")
    public void postCarrona(@RequestBody Carrona carrona){
        service.save(carrona);
    }

    @PutMapping(path = "/carronas/{id}")
    public void putCarrona(@RequestBody Carrona carrona, @RequestParam UUID id){
        service.update(carrona, id);
    }

    @DeleteMapping(path = "/carronas/{id}")
    public void deleteCarrona(@RequestParam UUID id){
        service.deleteById(id);
    }
}