package org.com.programming.segurancaTest.service;

import org.com.programming.segurancaTest.entities.DTOtarefas.TarefasLisAuxDTO;
import org.com.programming.segurancaTest.entities.DTOusuario.DTOcreateUsuario;
import org.com.programming.segurancaTest.entities.DTOusuario.UsuarioDTO;
import org.com.programming.segurancaTest.entities.DTOusuario.UsuarioListDTO;
import org.com.programming.segurancaTest.entities.UsuarioEntity;
import org.com.programming.segurancaTest.jpa.JpaTarefas;
import org.com.programming.segurancaTest.jpa.JpaUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {

    private final JpaUsuario jpaUsuario;
    private final JpaTarefas jpaTarefas;

    public ServiceUsuario(JpaUsuario jpaUsuario, JpaTarefas jpaTarefas) {
        this.jpaUsuario = jpaUsuario;
        this.jpaTarefas = jpaTarefas;
    }

    /* Aqui é o seguinte, o usuário só vai se criar. Ele não precisa ter uma lista de tarefas de forma obrigatória. */
    public DTOcreateUsuario usuarioCreate(UsuarioDTO usuarioDTO){
        UsuarioEntity user = new UsuarioEntity();
        user.setUserName(usuarioDTO.nomeUsuario());
        user.setUserPassword(usuarioDTO.passwordUsuario());
        UsuarioEntity obj = jpaUsuario.save(user);

        return new DTOcreateUsuario(obj.getIdUser(), obj.getUserName());
    }
    
    public List<UsuarioListDTO> usuarioEntities(){

        /* Dessa forma não reconhece que é do usuário.*/
        return jpaUsuario.findAll().stream()
                .map(usuarioEntity -> {
                    List<TarefasLisAuxDTO> tarefasLisAuxDTOS = usuarioEntity.getTarefaEntities()
                            .stream().map(c -> new TarefasLisAuxDTO(c.getDescricao(), c.getConcluida())).toList();
                    return new UsuarioListDTO(usuarioEntity.getUserName(), tarefasLisAuxDTOS);
                }).toList();

        /* Aqui é o seguinte:
        * 1 -> Vou percorrer uma lista de usuários usando o jpaUsuario.
        * 2 -> Para cada lista de tarefa do usuário, eu vou montar o seu DTO.
        * 3 -> No final retornaremos um novo DTO de UsuarioListDTO formatado. */
    }
}
