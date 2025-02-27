package com.example.carronas.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Carrona {

    @Id
    UUID id;

    @ManyToMany
    @JoinTable(
            name = "carronas_cidades",
            joinColumns = @JoinColumn(name = "carrona_id"),
            inverseJoinColumns = @JoinColumn(name = "cidade_id")
    )
    List<Cidade> cidades;

    @OneToMany(
            mappedBy = "carronaAtual"
    )
    List<User> passageiros;

    String descricao;

    public Carrona() {
    }

    public Carrona(UUID id, List<Cidade> cidades, List<User> passageiros, String descricao) {
        this.id = id;
        this.cidades = cidades;
        this.passageiros = passageiros;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<User> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<User> passageiros) {
        this.passageiros = passageiros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
