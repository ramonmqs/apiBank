package com.example.apibank.repository;

import com.example.apibank.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);
}
