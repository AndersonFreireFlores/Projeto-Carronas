package com.example.carronas.Services;

import com.example.carronas.Models.Carrona;
import com.example.carronas.Models.DTOs.CarronaDto;
import com.example.carronas.Models.DTOs.UserDto;
import com.example.carronas.Models.Mappers.CarronaMapper;
import com.example.carronas.Models.Mappers.UserMapper;
import com.example.carronas.Models.User;
import com.example.carronas.Repositories.CarronaRepository;
import com.example.carronas.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    private final CarronaMapper carronaMapper;

    private final CarronaRepository carronaRepository;

    public UserService(UserRepository repository, UserMapper mapper, CarronaMapper carronaMapper, CarronaRepository carronaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.carronaMapper = carronaMapper;
        this.carronaRepository = carronaRepository;
    }

    @Transactional
    public List<UserDto> getAllUsers(){
        List<User> list = repository.findAll();
        return list.stream().map(mapper::toDto).toList();
    }

    @Transactional
    public UserDto getByID(UUID id){
        User user = repository.findById(id).orElseThrow
                (() -> new RuntimeException("User not found. id: "+id));
        return mapper.toDto(user);
    }

    @Transactional
    public void createUser(User user){
        repository.save(user);
    }

    @Transactional
    public User updateUser(User userAtualizado, UUID carronaId){
        User userAntigo = repository.findById(userAtualizado.getId()).orElseThrow
                (() -> new RuntimeException("User not found. id: "+userAtualizado.getId()));

        userAntigo.setNome(userAtualizado.getNome());
        userAntigo.setCpf(userAtualizado.getCpf());
        userAntigo.setNum_matricula(userAtualizado.getNum_matricula());
        userAntigo.setEmail(userAntigo.getEmail());
        userAntigo.setCidade(userAntigo.getCidade());
        userAntigo.setAluno(userAtualizado.isAluno());

        updateCarrona(userAntigo.getId(), carronaId);

        repository.save(userAntigo);
        return userAntigo;
    }

    @Transactional
    public void updateCarrona(UUID userId, UUID carronaId){
        User userAntigo = repository.findById(userId).orElseThrow
                (() -> new RuntimeException("User not found. id: "+userId));
        Carrona carrona = carronaRepository.findById(carronaId).orElseThrow
                (() -> new RuntimeException("Carrona not found. id: "+carronaId));

        userAntigo.setCarronaAtual(carrona);
    }

    @Transactional
    public void deleteUser(UUID id){
        repository.deleteById(id);
    }
}
