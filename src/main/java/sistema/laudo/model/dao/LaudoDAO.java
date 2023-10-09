package sistema.laudo.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.laudo.br.FabricaConexao;
import sistema.laudo.model.entities.Laudo;
import sistema.laudo.model.entities.StatusLaudo;

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
    
    public static Laudo procurarLaudo(int laudoId) throws SQLException {
        Laudo laudo = null;

        try (Connection connection = FabricaConexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM laudos WHERE id = ?")) {

            preparedStatement.setInt(1, laudoId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                laudo = new Laudo();
                laudo.setId(resultSet.getInt("id"));
                laudo.setExameId(resultSet.getInt("exame_id"));
                laudo.setCrm(resultSet.getString("crm"));
                laudo.setDescricao(resultSet.getString("descricao"));
                laudo.setConclusao(resultSet.getString("conclusao"));
                laudo.setStatus(StatusLaudo.converterStringParaStatusLaudo(resultSet.getString("status")));
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao procurar o laudo por ID", e);
        }

        return laudo;
    }//procurarLaudo()
    
    public static List<Laudo> pesquisarTodosLaudos() throws SQLException {
        List<Laudo> laudos = new ArrayList<>();

        try (Connection connection = FabricaConexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM laudos")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Laudo laudo = new Laudo();
                laudo.setId(resultSet.getInt("id"));
                laudo.setExameId(resultSet.getInt("exame_id"));
                laudo.setCrm(resultSet.getString("crm"));
                laudo.setDescricao(resultSet.getString("descricao"));
                laudo.setConclusao(resultSet.getString("conclusao"));
                laudo.setStatus(StatusLaudo.converterStringParaStatusLaudo(resultSet.getString("status")));

                laudos.add(laudo);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao pesquisar todos os laudos", e);
        }

        return laudos;
    }//pesquisarTodosLaudos()
    
    public static void atualizarLaudo(Laudo laudo) throws SQLException {
        try (Connection connection = FabricaConexao.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE laudos SET exame_id = ?, crm = ?, descricao = ?, conclusao = ?, status = ? WHERE id = ?")) {

            preparedStatement.setInt(1, laudo.getExameId());
            preparedStatement.setString(2, laudo.getCrm());
            preparedStatement.setString(3, laudo.getDescricao());
            preparedStatement.setString(4, laudo.getConclusao());
            preparedStatement.setString(5, laudo.getStatusStr());
            preparedStatement.setInt(6, laudo.getId()); 

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar laudo", e);
        }
    }//atualizarLaudo()

}//LaudoDAO
