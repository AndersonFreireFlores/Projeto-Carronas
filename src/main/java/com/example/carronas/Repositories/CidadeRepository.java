package com.example.carronas.Repositories;

import com.example.carronas.Models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,UUID> {
}
