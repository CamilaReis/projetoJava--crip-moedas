/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Ripple extends Moedas { //ripple herda de moeda 

    public Ripple(double cotacao) { //recebe cotaçao inicial
        super("Ripple", "XRP", cotacao);
        //passa nome,sigla e cotacao
    }

}