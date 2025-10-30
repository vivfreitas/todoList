package org.com.programming.segurancaTest.jpa;

import org.com.programming.segurancaTest.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTarefas extends JpaRepository<TarefaEntity, Long> {
}
