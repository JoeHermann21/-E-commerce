/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Carrinho;
import br.com.modelo.ItemCarrinho;
import br.com.util.ConexaoBanco;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author e.andre.germano
 */
public class CarrinhoDAOImpl implements CarrinhoDAO{
    
    private Connection conexao;

    public CarrinhoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public CarrinhoDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public Carrinho getCarrinhoPorId(Integer carrinhoId) {
        
        try{
            Carrinho carrinho = new Carrinho();
            
            PreparedStatement st = conexao.prepareCall("select * from carrinho where carrinhoId=?");
            st.setInt(1, carrinho.getCarrinhoId());
            ResultSet rs = st.executeQuery();
            
            ItemCarrinho itemCarrinho = new ItemCarrinho();
            
            while(rs.next()){
                carrinho.setPrecoTotal(rs.getDouble("precoTotal"));
                itemCarrinho.setItemCarrinhoId(rs.getInt("itemCarrinho_fk"));
            }
            
            return carrinho;
        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public Carrinho validarCarrinho(Integer carrinhoId) throws IOException {
        Carrinho carrinho = getCarrinhoPorId(carrinhoId);
		if (carrinho == null || carrinho.getItemCarrinho().size() == 0) {
			throw new IOException(carrinhoId + "");
		}
		atualizarCarrinho(carrinho);
		return carrinho;
    }

    @Override
    public void atualizarCarrinho(Carrinho carrinho) {
        
        try{
            
            PreparedStatement st = conexao.prepareStatement("update carrinho set precoTotal=?, itemCarrinho_fk=? "
                    + "where carrinhoId=?");
            
                       
            st.setDouble(1, carrinho.getPrecoTotal());
            st.setArray(2, (Array) carrinho.getItemCarrinho());
            st.executeUpdate();
            
        
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        
    } 
    
}
