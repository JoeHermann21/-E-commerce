/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Pedido;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public interface PedidoDAO {
    
    void adicionarPedido(Pedido pedido);
    void alterarPedido(Pedido pedido);
    void excluirPedido(Pedido pedido);
    List<Pedido> getTodosPedidos();
    Pedido getPedidoPorId(Pedido pedido);
        
}
