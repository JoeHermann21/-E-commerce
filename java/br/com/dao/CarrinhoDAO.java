/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Carrinho;
import java.io.IOException;

/**
 *
 * @author e.andre.germano
 */
public interface CarrinhoDAO {
    
    Carrinho getCarrinhoPorId(Integer carrinhoId);
    Carrinho validarCarrinho(Integer carrinhoId) throws IOException;
    void atualizarCarrinho(Carrinho carrinho);
    
}
