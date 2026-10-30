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

    public void comprar(Moedas moeda, double valorReais, double taxaCompra) {
        if (valorReais <= 0) {
            throw new IllegalArgumentException(
                "O valor da compra deve ser positivo."
            );
        }

        if (valorReais > saldoReais) {
            throw new IllegalArgumentException(
                "Saldo insuficiente."
            );
        }

        double taxa = valorReais * taxaCompra;
        double valorLiquido = valorReais - taxa;
        double quantidade = valorLiquido / moeda.getCotacao();

        saldoReais -= valorReais;

        if (moeda.getSigla().equals("BTC")) {
            saldoBitcoin += quantidade;
        } else if (moeda.getSigla().equals("ETH")) {
            saldoEthereum += quantidade;
        } else if (moeda.getSigla().equals("XRP")) {
            saldoRipple += quantidade;
        } else {
            throw new IllegalArgumentException("Moeda inválida.");
        }

        registrarOperacao(new Operacao(
            "Compra de " + moeda.getNome(),
            valorReais,
            moeda.getCotacao(),
            taxa
        ));
    }
        public void vender(Moedas moeda, double quantidade, double taxaVenda) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade da venda deve ser positiva."
            );
        }

        double saldoMoeda;

        if (moeda.getSigla().equals("BTC")) {
            saldoMoeda = saldoBitcoin;
        } else if (moeda.getSigla().equals("ETH")) {
            saldoMoeda = saldoEthereum;
        } else if (moeda.getSigla().equals("XRP")) {
            saldoMoeda = saldoRipple;
        } else {
            throw new IllegalArgumentException("Moeda inválida.");
        }
    System.out.println("Saldo disponível: " + saldoMoeda);
    System.out.println("Quantidade solicitada: " + quantidade);
    if (quantidade > saldoMoeda + 0.000000000000001) {
        throw new IllegalArgumentException(
            "Saldo insuficiente de criptomoeda."
    );
}

        double valorBruto = quantidade * moeda.getCotacao();
        double taxa = valorBruto * taxaVenda;
        double valorLiquido = valorBruto - taxa;

        if (moeda.getSigla().equals("BTC")) {
            saldoBitcoin -= quantidade;
        } else if (moeda.getSigla().equals("ETH")) {
            saldoEthereum -= quantidade;
        } else {
            saldoRipple -= quantidade;
        }

        saldoReais += valorLiquido;

        registrarOperacao(new Operacao(
            "Venda de " + moeda.getNome(),
            valorLiquido,
            moeda.getCotacao(),
            taxa
        ));
    }
}