/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Bitcoin extends Moedas { //bitcoin herda de moeda 

    public Bitcoin(double cotacao) { //recebe cotaçao inicial
        super("Bitcoin", "BTC", cotacao);
        //passa nome,sigla e cotacao
    }

}