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


    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserDto> getAllUsers(){
        List<User> list = repository.findAll();
        return list.stream().map(mapper::toDto).toList();
    }

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

        repository.save(userAntigo);
        return userAntigo;
    }



    @Transactional
    public void deleteUser(UUID id){
        repository.deleteById(id);
    }
}
