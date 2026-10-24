/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author camil
 */
public class Carteira {
    //esponsável por guardar os saldos do investidor
    //precisamos controlar reais, Bitcoin, Ethereum e Ripple.
    
    private double saldoReais; //dinheiro disponível para depósitos,saques,compras.
    private double saldoBitcoin;  // quantidades de cada criptomoeda 
    private double saldoEthereum; // quantidades de cada criptomoeda 
    private double saldoRipple; // quantidades de cada criptomoeda 
    private List<Operacao> operacoes = new ArrayList<>();

 //Criar o construtor e os métodos de consulta da carteira
    public Carteira() {
    this.saldoReais = 0.0;
    this.saldoBitcoin = 0.0;
    this.saldoEthereum = 0.0;
    this.saldoRipple = 0.0;
}
 // get para consultar os saldos 
public double getSaldoReais() {
    return saldoReais;
}

public double getSaldoBitcoin() {
    return saldoBitcoin;
}

public double getSaldoEthereum() {
    return saldoEthereum;
}

public double getSaldoRipple() {
    return saldoRipple;
}

// set para atualizar os saldos 
public void setSaldoReais(double saldoReais) {
    this.saldoReais = saldoReais;
}

public void setSaldoBitcoin(double saldoBitcoin) {
    this.saldoBitcoin = saldoBitcoin;
}

public void setSaldoEthereum(double saldoEthereum) {
    this.saldoEthereum = saldoEthereum;
}

public void setSaldoRipple(double saldoRipple) {
    this.saldoRipple = saldoRipple;
}

public void registrarOperacao(Operacao operacao) { //adiciona uma operação ao histórico.
    operacoes.add(operacao);
}

public List<Operacao> getOperacoes() { //permite consultar o histórico
    return new ArrayList<>(operacoes);
}

    public void depositar(double valor) { // recebe o valor depositado
        if (valor <= 0) { //inpede depositos sendo zero ou menor 
            throw new IllegalArgumentException(
                "O valor do depósito deve ser positivo."
            );
        }

        saldoReais += valor; //soma deposito em saldo reais

        registrarOperacao(
            new Operacao("Depósito", valor, 0.0, 0.0)
        );
    }
    public void sacar(double valor) { //confer saldo positivo ou n 
    if (valor <= 0) {
        throw new IllegalArgumentException(
            "O valor do saque deve ser positivo."
        );
    }

    if (valor > saldoReais) { // impede saque insuficiente 
        throw new IllegalArgumentException(
            "Saldo insuficiente."
        );
    }

    saldoReais -= valor; // desconta o valor em reais 

    registrarOperacao( // registra o saque em hist d operacao 
        new Operacao("Saque", valor, 0.0, 0.0)
    );
}

}
