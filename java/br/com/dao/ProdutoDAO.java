/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Produto;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public interface ProdutoDAO {
    
    List<Produto> getTodosProdutos();
    Produto getProdutoPorId(Produto produto);
    void excluirProduto(Produto produto);
    void adicionarProduto(Produto produto);
    void editarProduto(Produto produto);
    
}
