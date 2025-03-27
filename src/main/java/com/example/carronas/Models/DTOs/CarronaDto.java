package com.example.carronas.Models.DTOs;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class CarronaDto implements Serializable {
    private final UUID id;
    private final List<UserDto1> passageiros;
    private final String descricao;

    public CarronaDto(UUID id, List<UserDto1> passageiros, String descricao) {
        this.id = id;
        this.passageiros = passageiros;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public List<UserDto1> getPassageiros() {
        return passageiros;
    }

    public String getDescricao() {
        return descricao;
    }


    public static class UserDto1 implements Serializable {
        private final String nome;
        private final String cidade;
        private final String email;
        private final boolean aluno;

        public UserDto1(String nome, String cidade, String email, boolean aluno) {
            this.nome = nome;
            this.cidade = cidade;
            this.email = email;
            this.aluno = aluno;
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
}