package com.example.carronas.Controllers;

import com.example.carronas.Models.Cidade;
import com.example.carronas.Models.DTOs.CidadeDto;
import com.example.carronas.Services.CidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CidadeController {

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @GetMapping(path = "/cidades")
    public List<CidadeDto> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/cidades/{id}")
    public CidadeDto getById(UUID id) {
        return service.getById(id);
    }

    @PostMapping(path = "/cidades")
    public void postCidade(@RequestBody Cidade cidade){
        service.save(cidade);
    }

    @PutMapping(path = "/cidades/{id}")
    public void putCidade(@RequestBody Cidade cidade, @RequestParam UUID id){
        service.update(cidade, id);
    }

    @DeleteMapping(path = "/cidades/{id}")
    public void deleteCidade(@RequestParam UUID id){
        service.deleteById(id);
    }

}
