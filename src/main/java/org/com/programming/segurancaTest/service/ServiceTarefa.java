package org.com.programming.segurancaTest.service;

import org.com.programming.segurancaTest.entities.DTOtarefas.CreateTarefaDTO;
import org.com.programming.segurancaTest.entities.TarefaEntity;
import org.com.programming.segurancaTest.entities.UsuarioEntity;
import org.com.programming.segurancaTest.jpa.JpaTarefas;
import org.com.programming.segurancaTest.jpa.JpaUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServiceTarefa {

    private final JpaTarefas jpaTarefas;
    private final JpaUsuario jpaUsuario;
    public ServiceTarefa(JpaTarefas jpaTarefas, JpaUsuario jpaUsuario) {
        this.jpaTarefas = jpaTarefas;
        this.jpaUsuario = jpaUsuario;
    }

    public TarefaEntity tarefaCreate(CreateTarefaDTO createTarefaDTO){
        UsuarioEntity obj = jpaUsuario.getReferenceById(createTarefaDTO.idUser());
       if(obj != null){
           TarefaEntity entity = new TarefaEntity();
           entity.setDescricao(createTarefaDTO.descricao());
           entity.setConcluida(createTarefaDTO.concluida());
           entity.setUsuarioEntity(obj);

           /* PRECISO RETORNAR UM DTO QUE SÓ TENHA O NOME DO USUÁRIO E A LISTA DE TAREFAS. */
           /* CRIARIA UM OUTRO DTO PARA FAZER O RETORNO SIMPLES. A NÃO SER QUE USEMOS createTarefaDTO como retorno. */
       } else {
           System.out.println("Errou.");
       }

    }
}
