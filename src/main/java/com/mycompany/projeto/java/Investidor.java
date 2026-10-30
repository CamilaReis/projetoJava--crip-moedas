
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Investidor extends Pessoa {
    private Carteira carteira; //nvestidor terá uma carteira
    
    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    //chama o construtor da classe Pessoa para inicializar os dados herdados.
        this.carteira = new Carteira();
}
    public Carteira getCarteira() {
    return carteira;
}
    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
}
}
