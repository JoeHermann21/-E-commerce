/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Cliente;
import br.com.modelo.PrivilegioAcesso;
import static br.com.modelo.PrivilegioAcesso.COMUM;
import br.com.modelo.Usuario;
import br.com.util.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }

    public UsuarioDAOImpl() {
        this.conexao = new ConexaoBanco().getConexao();
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        try {

            PreparedStatement st = conexao.prepareStatement("insert into cliente (email, senha, ativo, privilegioAcesso) values "
                    + "(?,?,?,?)");

            st.setString(1, usuario.getEmail());
            st.setString(2, usuario.getSenha());
            st.setBoolean(3, usuario.isAtivo());
            st.setString(4, COMUM.toString());
            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> getTodosUsuarios() {

        try {
            
            PreparedStatement st = conexao.prepareStatement("select * from usuario");

            ResultSet rs = st.executeQuery();
            List<Usuario> lista = new ArrayList<>();
            
            
            while (rs.next()){
                Usuario usuario = new Usuario();                
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuario.setPrivilegioAcesso(PrivilegioAcesso.valueOf(rs.getString("privilegioAcesso")));
                lista.add(usuario);
            }
            
            return lista;
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario getUsuarioPorId(Usuario usuario) {
        try {
            
            PreparedStatement st = conexao.prepareStatement("select * from usuario where usuarioId=?");
            st.setInt(1, usuario.getUsuarioId());
            ResultSet rs = st.executeQuery();
            
             while (rs.next()){            
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuario.setPrivilegioAcesso(PrivilegioAcesso.valueOf(rs.getString("privilegioAcesso")));
             }
            
            return usuario;
        
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override    
    public void atualizarUsuario(Usuario usuario) {
        
        try{
            
            PreparedStatement st = conexao.prepareStatement("update usuario set email=?, senha=?, ativo=?, privilegioAcesso=? "
                    + "where usuarioId=?");
            
            st.setString(1, usuario.getEmail());
            st.setString(2, usuario.getSenha());
            st.setBoolean(3, usuario.isAtivo());
            st.setString(4, usuario.getPrivilegioAcesso().toString());
            st.executeUpdate();
        
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
       try {

            PreparedStatement st = conexao.prepareStatement("delete from usuario where usuarioId=?");
            st.setInt(1, usuario.getUsuarioId());

            st.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }    
    }
    
     public Usuario autenticaUsuario(Usuario usuario) {
        Usuario usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = ConexaoBanco.getConexao();
            pstmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=?");
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();
            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setEmail(rsUsuario.getString("email"));
                usuarioAutenticado.setSenha(rsUsuario.getString("senha"));
                usuarioAutenticado.setPrivilegioAcesso(PrivilegioAcesso.valueOf(rsUsuario.getString("perfil")));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }

}
