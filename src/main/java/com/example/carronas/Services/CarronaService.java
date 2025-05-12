package com.example.carronas.Services;

import com.example.carronas.Models.Carrona;
import com.example.carronas.Models.DTOs.CarronaDto;
import com.example.carronas.Models.Mappers.CarronaMapper;
import com.example.carronas.Repositories.CarronaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarronaService {

    private final CarronaRepository repository;

    private final CarronaMapper mapper;

    public CarronaService(CarronaRepository repository, CarronaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public CarronaDto getById(UUID id){
        Carrona carrona = repository.findById(id).orElseThrow
                (() -> new RuntimeException("Carrona not found. id: "+id));
        return mapper.toDto(carrona);
    }

    public List<CarronaDto> getAll(){
        List<Carrona> list = repository.findAll();
        return list.stream().map(mapper::toDto).toList();
    }

    @Transactional
    public void save(Carrona carrona){
        repository.save(carrona);
    }

    @Transactional
    public void update(Carrona carronaAtualizada, UUID id){
        Carrona userAntigo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrona not found. id: "+id));
        userAntigo.setDescricao(carronaAtualizada.getDescricao());
        userAntigo.setCidades(carronaAtualizada.getCidades());
        userAntigo.setPassageiros(carronaAtualizada.getPassageiros());
        repository.save(userAntigo);
    }

    @Transactional
    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
