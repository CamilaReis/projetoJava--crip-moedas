/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
   
    //preciso fazer Investidor herda de Pessoa e possui uma Carteira.
    
}
