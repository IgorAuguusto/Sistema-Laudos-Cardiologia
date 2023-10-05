package sistema.laudo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sistema.laudo.br.FabricaConexao;
import sistema.laudo.model.entities.Laudo;

public class LaudoDAO {

    public static void inserirLaudo(Laudo laudo) throws SQLException {
        try (Connection connection = FabricaConexao.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO laudos (exame_id, crm, descricao, conclusao, status) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, laudo.getExameId());
            preparedStatement.setString(2, laudo.getCrm());
            preparedStatement.setString(3, laudo.getDescricao());
            preparedStatement.setString(4, laudo.getConclusao());
            preparedStatement.setString(5, laudo.getStatusStr());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir laudo", e);
        }
    }//inserirLaudo()

}//LaudoDAO
