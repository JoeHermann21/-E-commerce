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
public class ItemCarrinho extends Produto {

    private Integer itemCarrinhoId;
    private Integer quantidade;
    private Double precoTotal;
    private Produto produto;

    public ItemCarrinho() {
    }

    public ItemCarrinho(Integer itemCarrinhoId, Integer quantidade, Double preco, Double precoTotal, Produto produto) {
        this.itemCarrinhoId = itemCarrinhoId;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
        this.produto = produto;
    }

    public ItemCarrinho(Integer itemCarrinhoId) {
        this.itemCarrinhoId = itemCarrinhoId;
    }

    public Integer getItemCarrinhoId() {
        return itemCarrinhoId;
    }

    public void setItemCarrinhoId(Integer itemCarrinhoId) {
        this.itemCarrinhoId = itemCarrinhoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Double getPrecoTotal(){
        return precoTotal;
    }
    
    public void setPrecoTotal(Double precoTotal){
        this.precoTotal = precoTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    

}
