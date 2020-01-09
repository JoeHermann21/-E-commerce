/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Carrinho;
import br.com.modelo.ItemCarrinho;
import br.com.util.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public class ItemCarrinhoDAOImpl implements ItemCarrinhoDAO{
    
    private Connection conexao;

    public ItemCarrinhoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public ItemCarrinhoDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public void adicionarItemCarrinho(ItemCarrinho itemCarrinho) {
        
        try{
            
            PreparedStatement st = conexao.prepareStatement("insert into itemCarrinho (quantidade, precoTotal, produto_fk) "
                    + "values (?,?,?) ");
            
            st.setInt(1, itemCarrinho.getQuantidade());
            st.setDouble(2, itemCarrinho.getPrecoTotal());
            st.setInt(3, itemCarrinho.getProduto().getProdutoId());
            st.execute();
        
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerItemCarrinho(Integer itemCarrinhoId) {
        
        try{
            
            ItemCarrinho itemCarrinho = new ItemCarrinho();
            
            PreparedStatement st = conexao.prepareStatement("delete from itemCarrinho where itemCarrinhoId=?");
            st.setInt(1, itemCarrinho.getItemCarrinhoId());
            
            st.execute();
        
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerTodosItensCarrinho(Carrinho carrinho) {
        
        List<ItemCarrinho> itemCarrinho = carrinho.getItemCarrinho();
        for(ItemCarrinho ic : itemCarrinho){
            removerItemCarrinho(ic.getItemCarrinhoId());
        }
        
    }

    
    
}
