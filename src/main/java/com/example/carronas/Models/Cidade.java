package com.example.carronas.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Cidade {

    @Id
    UUID id;

    String nome;

    @ManyToMany(mappedBy = "cidades")
    List<Carrona> carronas;

    public Cidade() {
    }

    public Cidade(UUID id, String nome, List<Carrona> carronas) {
        this.id = id;
        this.nome = nome;
        this.carronas = carronas;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carrona> getCarronas() {
        return carronas;
    }

    public void setCarronas(List<Carrona> carronas) {
        this.carronas = carronas;
    }
}
