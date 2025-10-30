package org.com.programming.segurancaTest.service;

import org.com.programming.segurancaTest.entities.DTOtarefas.RequestCreateTarefa;
import org.com.programming.segurancaTest.entities.DTOtarefas.DTOcreateTarefa;
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

    public DTOcreateTarefa tarefaCreate(RequestCreateTarefa requestCreateTarefa){
        UsuarioEntity obj = jpaUsuario.getReferenceById(requestCreateTarefa.idUser()); /* Procuro o usuário. */

        TarefaEntity entity = new TarefaEntity();
        entity.setDescricao(requestCreateTarefa.descricao());
        entity.setConcluida(requestCreateTarefa.concluida());
        entity.setUsuarioEntity(obj);
        TarefaEntity tarefas = jpaTarefas.save(entity);
        /* AGORA QUE A TAREFA ESTÁ SALVA, VAMOS CRIAR UM DTO PARA RETORNAR A RESPOSTA PARA O USUÁRIO. */
        return new DTOcreateTarefa(tarefas.getDescricao(), tarefas.getConcluida(), tarefas.getUsuarioEntity().getUserName());


    }
}
