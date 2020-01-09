/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Cliente;
import br.com.modelo.Usuario;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public interface UsuarioDAO {
    
    void adicionarUsuario(Usuario usuario);
    List<Usuario> getTodosUsuarios();
    Usuario getUsuarioPorId(Usuario usuario);
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(Usuario usuario);
    Usuario autenticaUsuario(Usuario usuario);
    
}
