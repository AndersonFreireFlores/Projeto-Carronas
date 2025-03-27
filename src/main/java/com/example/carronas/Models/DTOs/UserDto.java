package com.example.carronas.Models.DTOs;

import java.io.Serializable;
import java.util.UUID;


public class UserDto implements Serializable {
    private final UUID id;
    private final String nome;
    private final String cidade;
    private final String email;
    private final boolean aluno;

    public UserDto(UUID id, String nome, String cidade, String email, boolean aluno) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.aluno = aluno;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEmail() {
        return email;
    }

    public boolean getAluno() {
        return aluno;
    }
}