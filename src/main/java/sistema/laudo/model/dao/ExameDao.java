package sistema.laudo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import sistema.laudo.br.FabricaConexao;
import sistema.laudo.model.entities.Exame;

public class ExameDao {
	
	 public static void inserirExame(Exame exame) throws SQLException {
	        try (Connection connection = FabricaConexao.getConnection();
	                PreparedStatement preparedStatement = connection.prepareStatement(
	                        "INSERT INTO exames (paciente_cpf, exame, status, hipotese, data_pedido, crm, nome_medico)"
	                      + "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

	            preparedStatement.setString(1, exame.getPacienteCpf());
	            preparedStatement.setString(2, exame.getTipoExame());
	            preparedStatement.setString(3, exame.getStatus().getStatusExame());
	            preparedStatement.setString(4, exame.getHipotese());
	            preparedStatement.setTimestamp(5, Timestamp.valueOf(exame.getDataPedido()));
	            preparedStatement.setString(6, exame.getMedicoCrm());
	            preparedStatement.setString(7, exame.getNomeMedico());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            throw new SQLException("Erro ao inserir exame", e);
	        }
	    }//inserirExame()
	
	public static Exame procurarExame(String cpf) throws SQLException {
		try (Connection connection = FabricaConexao.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM exames WHERE paciente_cpf = ?")) {

			preparedStatement.setString(1, cpf);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					Exame exame = new Exame();
					
					exame.setPacienteCpf(resultSet.getString("paciente_cpf"));
					exame.setTipoExame(resultSet.getString("exame"));
					exame.setStatus(resultSet.getString("status"));
					exame.setHipotese(resultSet.getString("hipotese"));
					exame.setDataPedido(resultSet.getTimestamp("data_pedido").toLocalDateTime());
					exame.setMedicoCrm(resultSet.getString("crm"));
					exame.setNomeMedico(resultSet.getString("nome_medico"));
					
					if (resultSet.getBytes("pdf") != null) {
						exame.setPdf(resultSet.getBytes("pdf"));
					}
					if (resultSet.getTimestamp("data_realizacao") != null) {
						exame.setDataRealizacao(resultSet.getTimestamp("data_realizacao").toLocalDateTime());
					}
					
					return exame;

				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Erro ao procurar paciente", e);
		}
	}//procurarExame()

}//ExameDao
