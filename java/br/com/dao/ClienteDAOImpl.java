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
import br.com.modelo.Usuario;
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
public class ClienteDAOImpl implements ClienteDAO {

    private Connection conexao;

    public ClienteDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public ClienteDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        try {

            PreparedStatement st = conexao.prepareStatement("insert into cliente (nome, sobrenome, telefone, "
                    + "enderecoEntrega_fk, enderecoCobranca_fk, carrinho_fk, pedido_fk, usuario_fk) values "
                    + "(?,?,?,?,?,?,?,?)");

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSobrenome());
            st.setString(3, cliente.getTelefone());
            st.setInt(4, cliente.getEnderecoEntrega().getEnderecoId());
            st.setInt(5, cliente.getEnderecoCobranca().getEnderecoId());
            st.setInt(6, cliente.getCarrinho().getCarrinhoId());
            st.setInt(7, cliente.getPedido().getPedidoId());
            st.setInt(8, cliente.getUsuario().getUsuarioId());
            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> getTodosClientes() {
        try {

            PreparedStatement st = conexao.prepareStatement("select * from cliente");

            ResultSet rs = st.executeQuery();
            List<Cliente> lista = new ArrayList<>();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
                EnderecoCobranca enderecoCobranca = new EnderecoCobranca();
                Carrinho carrinho = new Carrinho();
                Pedido pedido = new Pedido();
                Usuario usuario = new Usuario();
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setTelefone(rs.getString("telefone"));
                enderecoEntrega.setEnderecoId(rs.getInt("enderecoEntrega_fk"));
                enderecoCobranca.setEnderecoId(rs.getInt("enderecoCobranca_fk"));
                carrinho.setCarrinhoId(rs.getInt("carrinho_fk"));
                pedido.setPedidoId(rs.getInt("pedido_fk"));
                usuario.setUsuarioId(rs.getInt("usuario_fk"));
                lista.add(cliente);

            }

            return lista;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente getClientePorId(Cliente cliente) {

        try {

            PreparedStatement st = conexao.prepareStatement("select * from cliente where clienteId=?");
            st.setInt(1, cliente.getClienteId());
            ResultSet rs = st.executeQuery();

            EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
            EnderecoCobranca enderecoCobranca = new EnderecoCobranca();
            Carrinho carrinho = new Carrinho();
            Pedido pedido = new Pedido();
            Usuario usuario = new Usuario();

            while (rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setTelefone(rs.getString("telefone"));
                enderecoEntrega.setEnderecoId(rs.getInt("enderecoEntrega_fk"));
                enderecoCobranca.setEnderecoId(rs.getInt("enderecoCobranca_fk"));
                carrinho.setCarrinhoId(rs.getInt("carrinho_fk"));
                pedido.setPedidoId(rs.getInt("pedido_fk"));
                usuario.setUsuarioId(rs.getInt("usuario_fk"));

            }
            
            return cliente;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        
        try{
            
            PreparedStatement st = conexao.prepareStatement("update cliente set nome=?, sobrenome=?, telefone=?,"
                    + "enderecoEntrega_fk=?, enderecoCobranca_fk=?, carrinho_fk=?, pedido_fk=?, usuario_fk=? where clienteId=?");
            
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSobrenome());
            st.setString(3, cliente.getTelefone());
            st.setInt(4, cliente.getEnderecoEntrega().getEnderecoId());
            st.setInt(5, cliente.getEnderecoCobranca().getEnderecoId());
            st.setInt(6, cliente.getCarrinho().getCarrinhoId());
            st.setInt(7, cliente.getPedido().getPedidoId());
            st.setInt(8, cliente.getUsuario().getUsuarioId());
            st.executeUpdate();
                    
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluirCliente(Cliente cliente){
        try {

            PreparedStatement st = conexao.prepareStatement("delete from cliente where clienteId=?");
            st.setInt(1, cliente.getClienteId());

            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
