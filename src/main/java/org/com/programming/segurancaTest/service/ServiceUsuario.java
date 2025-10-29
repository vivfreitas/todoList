package org.com.programming.segurancaTest.service;

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


    public UsuarioEntity usuarioCreate(UsuarioDTO usuarioDTO){
        UsuarioEntity user = new UsuarioEntity();
        user.setUserName(usuarioDTO.nomeUsuario());
        user.setUserPassword(usuarioDTO.passwordUsuario());
        return jpaUsuario.save(user);
    }

    public List<UsuarioEntity> usuarioEntities(){
        List<UsuarioEntity> obj = jpaUsuario.findAll();

    }
}
