package org.com.programming.segurancaTest.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(unique = true)
    private String userName;
    private String userPassword;

    @OneToMany(mappedBy = "usuarioEntity")
    private List<TarefaEntity> tarefaEntities;
    public UsuarioEntity(){}

    public UsuarioEntity(Long idUser, String userName, String userPassword, List<TarefaEntity> tarefaEntities) {
        this.idUser = idUser;
        this.userName = userName;
        this.userPassword = userPassword;
        this.tarefaEntities = tarefaEntities;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<TarefaEntity> getTarefaEntities() {
        return tarefaEntities;
    }

    public void setTarefaEntities(List<TarefaEntity> tarefaEntities) {
        this.tarefaEntities = tarefaEntities;
    }
}
