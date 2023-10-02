package sistema.laudo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sistema.laudo.br.FabricaConexao;
import sistema.laudo.model.entities.Paciente;

public class PacienteDao {
	
	public static Paciente procurarPaciente(String cpf) throws SQLException {
	    try (Connection connection = FabricaConexao.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE cpf = ?")) {

	        preparedStatement.setString(1, cpf);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	            	Paciente paciente = new Paciente();

	            	paciente.setCpf(resultSet.getString("cpf"));
	            	paciente.setDataNascimento(resultSet.getDate("data_nascimento").toLocalDate());
	            	paciente.setNome(resultSet.getString("nome"));
	            	paciente.setSexo(resultSet.getString("sexo").charAt(0));
	            	paciente.seteMail(resultSet.getString("email"));
	            	paciente.setIdade(resultSet.getInt("idade"));
	            	return paciente;
	               
	            } else {
	                return null; 
	            }
	        }
	    } catch (SQLException e) {
	        throw new SQLException("Erro ao procurar paciente", e);
	    }
	}//procurarPaciente()
}//PacienteDao
