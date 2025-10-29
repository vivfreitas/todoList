package org.com.programming.segurancaTest.entities.DTOusuario;

import org.com.programming.segurancaTest.entities.DTOtarefas.TarefasDTO;

import java.util.List;

public record UsuarioListDTO(String nomeUsuario, List<TarefasDTO> tarefasList) {
}
