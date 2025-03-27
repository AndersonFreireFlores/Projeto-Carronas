package com.example.carronas.Models.DTOs;

import java.io.Serializable;
import java.util.UUID;

public class CidadeDto implements Serializable {
    private final UUID id;
    private final String nome;

    public CidadeDto(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}