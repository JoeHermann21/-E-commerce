/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Produto;
import br.com.util.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public class ProdutoDAOImpl implements ProdutoDAO {

    private Connection conexao;

    public ProdutoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public ProdutoDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public List<Produto> getTodosProdutos() {

        try {

            PreparedStatement st = conexao.prepareStatement("select * from produto");

            ResultSet rs = st.executeQuery();
            List<Produto> lista = new ArrayList<>();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagem(rs.getString("imagem"));
                lista.add(produto);

            }

            return lista;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Produto getProdutoPorId(Produto produto) {

        try {

            PreparedStatement st = conexao.prepareStatement("select * from produto where produtoId=?");
            st.setInt(1, produto.getProdutoId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagem(rs.getString("imagem"));
            }

            return produto;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void excluirProduto(Produto produto) {

        try {

            PreparedStatement st = conexao.prepareStatement("delete from produto where produtoId=?");
            st.setInt(1, produto.getProdutoId());

            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void adicionarProduto(Produto produto) {

        try {

            PreparedStatement st = conexao.prepareStatement("insert into produto (nome,	categoria, descricao, preco, imagem) values "
                    + "(?, ?, ?, ?, ?)");

            st.setString(1, produto.getNome());
            st.setString(2, produto.getCategoria());
            st.setString(3, produto.getDescricao());
            st.setDouble(4, produto.getPreco());
            st.setString(5, produto.getImagem());
            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editarProduto(Produto produto) {

        try {

            PreparedStatement st = conexao.prepareStatement("update produto set nome=?,	categoria=?, descricao=?, preco=?, imagem=?"
                    + "where produtoId=?");

            st.setString(1, produto.getNome());
            st.setString(2, produto.getCategoria());
            st.setString(3, produto.getDescricao());
            st.setDouble(4, produto.getPreco());
            st.setString(5, produto.getImagem());
            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
