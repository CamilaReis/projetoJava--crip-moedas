
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Operacao {
    private String tipo; //depósito, saque, compra ou venda.
    private double valor; //guarda o valor movimentado.
    private double cotacao; //registra o preço da criptomoeda no momento da operação.
    private double taxa; //taxa cobrada pela operaçao
    
    
    public Operacao(String tipo, double valor, double cotacao, double taxa) {
        this.tipo = tipo;
        this.valor = valor;
        this.cotacao = cotacao;
        this.taxa = taxa;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public double getCotacao() {
        return cotacao;
    }

    public double getTaxa() {
        return taxa;
    }

    
}
