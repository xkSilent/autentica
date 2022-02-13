package com.aula.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.domain.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, String>{

	Optional<Usuario> findById(Integer id);

	Usuario findByEmail(String email);
}
