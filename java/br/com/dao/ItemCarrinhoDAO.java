/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Carrinho;
import br.com.modelo.ItemCarrinho;

/**
 *
 * @author e.andre.germano
 */
public interface ItemCarrinhoDAO {
    
    void adicionarItemCarrinho(ItemCarrinho itemCarrinho);
    void removerItemCarrinho(Integer itemCarrinhoId);
    void removerTodosItensCarrinho(Carrinho carrinho);
    
}
