package org.com.programming.segurancaTest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarefas")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefas;

    private String descricao;
    private Boolean concluida;
    @ManyToOne
    @JoinColumn(name = "tarefas_estrangeiras")
    private UsuarioEntity usuarioEntity;

    public TarefaEntity(){}

    public TarefaEntity(Long idTarefas, String descricao, Boolean concluida, UsuarioEntity usuarioEntity) {
        this.idTarefas = idTarefas;
        this.descricao = descricao;
        this.concluida = concluida;
        this.usuarioEntity = usuarioEntity;
    }

    public Long getIdTarefas() {
        return idTarefas;
    }

    public void setIdTarefas(Long idTarefas) {
        this.idTarefas = idTarefas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
