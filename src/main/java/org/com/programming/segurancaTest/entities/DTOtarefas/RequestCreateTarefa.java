package org.com.programming.segurancaTest.entities.DTOtarefas;

public record RequestCreateTarefa(Long idUser, String descricao, Boolean concluida) {
}
