
package com.mycompany.projeto.java;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class InvestidorDAO {
     private Conexao conexao = new Conexao();

    // Consulta um investidor pelo CPF.
    public Investidor consultarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT nome, cpf, senha FROM investidores WHERE cpf = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    String nome = resultado.getString("nome");
                    String cpfEncontrado = resultado.getString("cpf");
                    String senha = resultado.getString("senha");

                    return new Investidor(nome, cpfEncontrado, senha);
                }
            }
        }

        return null;
    }

    // Insere um novo investidor no banco de dados.
    public void inserir(Investidor investidor) throws SQLException {
        String sql = "INSERT INTO investidores (nome, cpf, senha) VALUES (?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, investidor.getNome());
            stmt.setString(2, investidor.getCpf());
            stmt.setString(3, investidor.getSenhaParaBanco());

            stmt.executeUpdate();
        }
    }
 // Cria uma carteira para o investidor, caso ainda não exista.
    public void criarCarteira(String cpf) throws SQLException {
        String sql = "INSERT INTO carteiras (investidor_id) "
                + "SELECT id FROM investidores WHERE cpf = ? "
                + "ON CONFLICT (investidor_id) DO NOTHING";

         try (Connection conn = conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

             stmt.setString(1, cpf);
             stmt.executeUpdate();
    }
} 
    // Consulta a carteira do investidor pelo CPF.
    public Carteira carregarCarteira(String cpf) throws SQLException {
        String sql = "SELECT c.saldo_reais, c.saldo_bitcoin, "
                + "c.saldo_ethereum, c.saldo_ripple "
                + "FROM carteiras c "
                + "INNER JOIN investidores i ON c.investidor_id = i.id "
                + "WHERE i.cpf = ?";

        try (Connection conn = conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    Carteira carteira = new Carteira();

                    carteira.setSaldoReais(resultado.getDouble("saldo_reais"));
                    carteira.setSaldoBitcoin(resultado.getDouble("saldo_bitcoin"));
                    carteira.setSaldoEthereum(resultado.getDouble("saldo_ethereum"));
                    carteira.setSaldoRipple(resultado.getDouble("saldo_ripple"));
                
                    return carteira;
            }
        }
    }

    return null;
}
    // Atualiza os saldos da carteira no banco de dados.
    public void salvarCarteira(String cpf, Carteira carteira) throws SQLException {
        String sql = "UPDATE carteiras SET saldo_reais = ?, "
                + "saldo_bitcoin = ?, saldo_ethereum = ?, saldo_ripple = ? "
                + "WHERE investidor_id = "
                + "(SELECT id FROM investidores WHERE cpf = ?)";

        try (Connection conn = conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, carteira.getSaldoReais());
            stmt.setDouble(2, carteira.getSaldoBitcoin());
            stmt.setDouble(3, carteira.getSaldoEthereum());
            stmt.setDouble(4, carteira.getSaldoRipple());
            stmt.setString(5, cpf);

            stmt.executeUpdate();
    }
}
    // Salva uma operação no banco de dados.
public void salvarOperacao(String cpf, Operacao operacao) throws SQLException {
    String sql = "INSERT INTO operacoes "
            + "(investidor_id, tipo, valor, cotacao, taxa) "
            + "SELECT id, ?, ?, ?, ? FROM investidores WHERE cpf = ?";

    try (Connection conn = conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, operacao.getTipo());
        stmt.setDouble(2, operacao.getValor());
        stmt.setDouble(3, operacao.getCotacao());
        stmt.setDouble(4, operacao.getTaxa());
        stmt.setString(5, cpf);

        stmt.executeUpdate();
    }
}
// Carrega o histórico de operações do investidor.
public List<Operacao> carregarOperacoes(String cpf) throws SQLException {
    List<Operacao> operacoes = new ArrayList<>();

    String sql = "SELECT o.tipo, o.valor, o.cotacao, o.taxa "
            + "FROM operacoes o "
            + "INNER JOIN investidores i ON o.investidor_id = i.id "
            + "WHERE i.cpf = ? "
            + "ORDER BY o.data_operacao, o.id";

    try (Connection conn = conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);

        try (ResultSet resultado = stmt.executeQuery()) {
            while (resultado.next()) {
                Operacao operacao = new Operacao(
                        resultado.getString("tipo"),
                        resultado.getDouble("valor"),
                        resultado.getDouble("cotacao"),
                        resultado.getDouble("taxa")
                );

                operacoes.add(operacao);
            }
        }
    }

    return operacoes;
}
}
