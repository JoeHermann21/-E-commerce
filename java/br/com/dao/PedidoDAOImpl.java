/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Carrinho;
import br.com.modelo.Cliente;
import br.com.modelo.EnderecoCobranca;
import br.com.modelo.EnderecoEntrega;
import br.com.modelo.Pedido;
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
public class PedidoDAOImpl implements PedidoDAO {

    private Connection conexao;

    public PedidoDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public PedidoDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {

        try {

            PreparedStatement st = conexao.prepareStatement("insert into pedido (carrinho_fk, enderecoEntrega_fk, enderecoCobranca_fk) "
                    + "values (?,?,?)");

            st.setInt(1, pedido.getCarrinho().getCarrinhoId());
            st.setInt(2, pedido.getEnderecoEntrega().getEnderecoId());
            st.setInt(3, pedido.getEnderecoCobrança().getEnderecoId());
            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarPedido(Pedido pedido) {

        try {

            PreparedStatement st = conexao.prepareStatement("update pedido set carrinho_fk=?, enderecoEntrega_fk=?, enderecoCobranca_fk=? "
                    + "where pedidoId=?");

            st.setInt(1, pedido.getCarrinho().getCarrinhoId());
            st.setInt(2, pedido.getEnderecoEntrega().getEnderecoId());
            st.setInt(3, pedido.getEnderecoCobrança().getEnderecoId());
            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluirPedido(Pedido pedido) {
        try {

            PreparedStatement st = conexao.prepareStatement("delete from pedido where pedidoId=?");
            st.setInt(1, pedido.getPedidoId());

            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pedido> getTodosPedidos() {
        try {

            PreparedStatement st = conexao.prepareStatement("select * from pedido");

            ResultSet rs = st.executeQuery();
            List<Pedido> lista = new ArrayList<>();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
                EnderecoCobranca enderecoCobranca = new EnderecoCobranca();
                Carrinho carrinho = new Carrinho();
                enderecoEntrega.setEnderecoId(rs.getInt("enderecoEntrega_fk"));
                enderecoCobranca.setEnderecoId(rs.getInt("enderecoCobranca_fk"));
                carrinho.setCarrinhoId(rs.getInt("carrinho_fk"));
                lista.add(pedido);

            }

            return lista;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Pedido getPedidoPorId(Pedido pedido) {

        try {

            PreparedStatement st = conexao.prepareStatement("select * from pedido where pedidoId=?");
            st.setInt(1, pedido.getPedidoId());
            ResultSet rs = st.executeQuery();

            EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
            EnderecoCobranca enderecoCobranca = new EnderecoCobranca();
            Carrinho carrinho = new Carrinho();

            while (rs.next()) {
                enderecoEntrega.setEnderecoId(rs.getInt("enderecoEntrega_fk"));
                enderecoCobranca.setEnderecoId(rs.getInt("enderecoCobranca_fk"));
                carrinho.setCarrinhoId(rs.getInt("carrinho_fk"));
            }

            return pedido;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
