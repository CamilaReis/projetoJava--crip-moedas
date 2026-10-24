/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Moedas {
    private String nome; // tipo de moeda
    private String sigla; //Identificação abreviada
    private double cotacao; //preço atual em reais 
    
    //siglas 
    //Bitcoin → BTC
    //Ethereum → ETH
    //Ripple → XRP

    public Moedas(String nome, String sigla, double cotacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.cotacao = cotacao;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
}
