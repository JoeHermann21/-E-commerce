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
public class Pedido {

    private Integer pedidoId;
    private Carrinho carrinho;
    private EnderecoEntrega enderecoEntrega;
    private EnderecoCobranca enderecoCobrança;

    public Pedido() {
    }

    public Pedido(Integer pedidoId, Carrinho carrinho, EnderecoEntrega enderecoEntrega, EnderecoCobranca enderecoCobrança) {
        this.pedidoId = pedidoId;
        this.carrinho = carrinho;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoCobrança = enderecoCobrança;
    } 

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EnderecoCobranca getEnderecoCobrança() {
        return enderecoCobrança;
    }

    public void setEnderecoCobrança(EnderecoCobranca enderecoCobrança) {
        this.enderecoCobrança = enderecoCobrança;
    }   
    
}
