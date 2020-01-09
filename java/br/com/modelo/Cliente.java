/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

/**
 *
 * @author e.andre.germano
 */
public class Cliente{
    
    private Integer clienteId;	
    private String nome;
    private String sobrenome;
    private String telefone;
    private EnderecoEntrega enderecoEntrega;
    private EnderecoCobranca enderecoCobranca;
    private Carrinho carrinho;
    private Pedido pedido;
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Integer clienteId, String nome, String sobrenome, String telefone, EnderecoEntrega enderecoEntrega, EnderecoCobranca enderecoCobranca, Carrinho carrinho, Pedido pedido, Usuario usuario) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoCobranca = enderecoCobranca;
        this.carrinho = carrinho;
        this.pedido = pedido;
        this.usuario = usuario;
    }
    
    public Cliente(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EnderecoCobranca getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(EnderecoCobranca enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
            
}
