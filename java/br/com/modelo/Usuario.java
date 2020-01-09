/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

/**
 *
 * @author e.andre.germano
 */
public class Usuario {

    private Integer usuarioId;
    private String email;
    private String senha;
    private boolean ativo;
    private PrivilegioAcesso privilegioAcesso;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String email, String senha, boolean ativo, PrivilegioAcesso privilegioAcesso) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.privilegioAcesso = privilegioAcesso;
    }   
    
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public PrivilegioAcesso getPrivilegioAcesso() {
        return privilegioAcesso;
    }

    public void setPrivilegioAcesso(PrivilegioAcesso privilegioAcesso) {
        this.privilegioAcesso = privilegioAcesso;
    }
    
       
    

}
