/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e.andre.germano
 */
public class Carrinho {
    
    private Integer carrinhoId;
    private Double precoTotal;
    private ArrayList<ItemCarrinho> itemCarrinho;

    public Carrinho() {
    }

    public Carrinho(Integer carrinhoId, Double precoTotal, ArrayList<ItemCarrinho> itemCarrinho, Cliente cliente) {
        this.carrinhoId = carrinhoId;
        this.precoTotal = precoTotal;
        this.itemCarrinho = itemCarrinho;
    }
    
    public Carrinho(Integer carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public Integer getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(Integer carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ItemCarrinho> getItemCarrinho() {
        return itemCarrinho;
    }

    public void setItemCarrinho(ArrayList<ItemCarrinho> itemCarrinho) {
        this.itemCarrinho = itemCarrinho;
    }  
    
}
