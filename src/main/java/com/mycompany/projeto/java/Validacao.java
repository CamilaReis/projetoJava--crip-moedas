
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Validacao {
     // Verifica se o CPF temexatamente 11 números.
    public static boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("[0-9]{11}");
    }

    // Verifica se a senha tem exatamente 6 números.
    public static boolean validarSenha(String senha) {
        return senha != null && senha.matches("[0-9]{6}");
    }

    // Verifica se o nome foi preenchido.
    public static boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
    
}
