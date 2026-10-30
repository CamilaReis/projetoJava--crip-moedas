/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.java;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author camil
 */
public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConnection()) {
            System.out.println("Conexão com PostgreSQL realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            e.printStackTrace();
        }
    }
    
    
}
