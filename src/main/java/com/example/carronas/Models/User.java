package com.example.carronas.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    UUID id;

    String nome;

    String cidade;

    String email;

    String cpf;

    boolean aluno;

    int num_matricula;

    @OneToMany
    List<Carrona> carronasDono;

    @ManyToOne
    Carrona carronaAtual;

    public User() {
    }

    public User(UUID id, String nome, String cidade, String email, String cpf, boolean aluno,
                int num_matricula) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.cpf = cpf;
        this.aluno = aluno;
        this.num_matricula = num_matricula;
    }

    public User(UUID id, String nome, String cidade, String email, String cpf, boolean aluno,
                int num_matricula, List<Carrona> carronasDono, Carrona carronaAtual) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.cpf = cpf;
        this.aluno = aluno;
        this.num_matricula = num_matricula;
        this.carronasDono = carronasDono;
        this.carronaAtual = carronaAtual;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAluno() {
        return aluno;
    }

    public void setAluno(boolean aluno) {
        this.aluno = aluno;
    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public List<Carrona> getCarronasDono() {
        return carronasDono;
    }

    public void setCarronasDono(List<Carrona> carronasDono) {
        this.carronasDono = carronasDono;
    }

    public Carrona getCarronaAtual() {
        return carronaAtual;
    }

    public void setCarronaAtual(Carrona carronaAtual) {
        this.carronaAtual = carronaAtual;
    }
}
