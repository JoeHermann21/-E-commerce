/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Cliente;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public interface ClienteDAO {
    
    void adicionarCliente(Cliente cliente);
    List<Cliente> getTodosClientes();
    Cliente getClientePorId(Cliente cliente);
    void atualizarCliente(Cliente cliente);
    void excluirCliente(Cliente cliente);
       
}
