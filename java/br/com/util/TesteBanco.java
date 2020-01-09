package br.com.util;

import br.com.util.ConexaoBanco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e.andre.germano
 */
public class TesteBanco {
    
    ConexaoBanco cb = null;    
    
    public static void main(String[] args) {
        
        ConexaoBanco.getConexao();
        
        if (ConexaoBanco.getConexao()==null){
            System.out.println("nulo");
        }else{
            System.out.println("Deu certo!!!");
        }
    }
}
