/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Ethereum extends Moedas { //Ethereum herda de moeda 

    public Ethereum (double cotacao) { //recebe cotaçao inicial
        super("Ethereum", "ETH", cotacao);
        //passa nome,sigla e cotacao
    }

}