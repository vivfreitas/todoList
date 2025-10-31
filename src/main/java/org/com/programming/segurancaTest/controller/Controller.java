package org.com.programming.segurancaTest.controller;

import org.com.programming.segurancaTest.entities.DTOtarefas.DTOcreateTarefa;
import org.com.programming.segurancaTest.entities.DTOtarefas.RequestCreateTarefa;
import org.com.programming.segurancaTest.entities.DTOusuario.DTOcreateUsuario;
import org.com.programming.segurancaTest.entities.DTOusuario.UsuarioDTO;
import org.com.programming.segurancaTest.entities.DTOusuario.UsuarioListDTO;
import org.com.programming.segurancaTest.service.ServiceTarefa;
import org.com.programming.segurancaTest.service.ServiceUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("teste")
@RestController
public class Controller {
    private final ServiceTarefa serviceTarefa;
    private final ServiceUsuario serviceUsuario;


    public Controller(ServiceTarefa serviceTarefa, ServiceUsuario serviceUsuario) {
        this.serviceTarefa = serviceTarefa;
        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping("tarefasCriadas")
    public ResponseEntity<DTOcreateTarefa> criarTarefas(@RequestBody RequestCreateTarefa requestCreateTarefa){
        DTOcreateTarefa obj = serviceTarefa.tarefaCreate(requestCreateTarefa);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("usuarioCriados")
    public ResponseEntity<DTOcreateUsuario> criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        DTOcreateUsuario  obj = serviceUsuario.usuarioCreate(usuarioDTO);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("listAll")
    public ResponseEntity<List<UsuarioListDTO>> entityLista(){
        List<UsuarioListDTO> listagem = serviceUsuario.usuarioEntities();
        return ResponseEntity.ok(listagem);
    }
}
