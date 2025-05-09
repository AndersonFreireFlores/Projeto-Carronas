package com.example.carronas.Services;

import com.example.carronas.Models.Cidade;
import com.example.carronas.Models.DTOs.CidadeDto;
import com.example.carronas.Models.Mappers.CidadeMapper;
import com.example.carronas.Repositories.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    private final CidadeMapper mapper;

    public CidadeService(CidadeRepository repository, CidadeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CidadeDto getById(UUID id){
        return mapper.toDto(repository.findById(id).orElseThrow
                (() -> new RuntimeException("Cidade not found. id: "+id)));
    }

    public List<CidadeDto> getAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional
    public void save(CidadeDto cidadeDto){
        repository.save(mapper.toEntity(cidadeDto));
    }

    @Transactional
    public void update(Cidade cidadeAtualizada, UUID id){
        Cidade cidadeAntiga = repository.findById(id).orElseThrow
                (() -> new RuntimeException("Cidade not found. id: "+id));

        cidadeAntiga.setNome(cidadeAtualizada.getNome());
        cidadeAntiga.setCarronas(cidadeAtualizada.getCarronas());
        repository.save(cidadeAntiga);

        repository.save(cidadeAntiga);

    }

    @Transactional
    public void deleteById(UUID id){
        repository.deleteById(id);
    }


}
