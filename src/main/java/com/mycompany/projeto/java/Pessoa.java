
package com.mycompany.projeto.java;

/**
 *
 * @author camil
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String senha;
    // nome,cpf,senha sao atributos da pessoa 
    
    public Pessoa(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
// os gets aqui retornam os atributos correspondentes.
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    // Confere se a senha digitada está correta.
    public boolean validarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }

    // Retorna a senha para uso interno no acesso ao banco.
    public String getSenhaParaBanco() {
        return senha;
    }

   
    
}
