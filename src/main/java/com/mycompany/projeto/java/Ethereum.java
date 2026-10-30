
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