package org.com.programming.segurancaTest.jpa;

import org.com.programming.segurancaTest.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuario extends JpaRepository<UsuarioEntity, Long> {
}
