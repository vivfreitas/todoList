package org.com.programming.segurancaTest.service;

import org.com.programming.segurancaTest.entities.DTOusuario.DTOcreateUsuario;
import org.com.programming.segurancaTest.entities.DTOusuario.UsuarioDTO;
import org.com.programming.segurancaTest.entities.UsuarioEntity;
import org.com.programming.segurancaTest.jpa.JpaUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {

    private final JpaUsuario jpaUsuario;

    public ServiceUsuario(JpaUsuario jpaUsuario) {
        this.jpaUsuario = jpaUsuario;
    }

    /* Aqui é o seguinte, o usuário só vai se criar. Ele não precisa ter uma lista de tarefas de forma obrigatória. */
    public DTOcreateUsuario usuarioCreate(UsuarioDTO usuarioDTO){
        UsuarioEntity user = new UsuarioEntity();
        user.setUserName(usuarioDTO.nomeUsuario());
        user.setUserPassword(usuarioDTO.passwordUsuario());
        UsuarioEntity obj = jpaUsuario.save(user);

        return new DTOcreateUsuario(obj.getIdUser(), obj.getUserName());
    }

    /* Agora precisamos criar uma lista de usuários que será:
    * {
    *   "nomeUsuario": "Vivian"
    *   "list-TodoList": [
    *                     ["Descrição": "Minha tarefa"
    *                      "Finalizada": True],
    *                      ["Descrição": "Minha tarefa"
     *                      "Finalizada": True]
     *                  ]
     * }
}*/

    
}
