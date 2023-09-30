package sistema.laudo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sistema.laudo.br.FabricaConexao;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.MedicoDocente;
import sistema.laudo.model.entities.MedicoResidente;
import sistema.laudo.model.entities.TipoMedico;

public class MedicoDAO {
	
	
	public static Medico procurarMedico(String crm, String senha) throws SQLException {
	    try (Connection connection = FabricaConexao.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicos WHERE crm = ? AND senha = ?")) {

	        preparedStatement.setString(1, crm);
	        preparedStatement.setString(2, senha);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                TipoMedico tipoMedico = TipoMedico.converterStringParaTipoMedico(resultSet.getString("tipo"));
	                Medico medico = null;

	                switch (tipoMedico) {
	                    case MEDICO:
	                        medico = instanciaMedico(resultSet);
	                        break;
	                    case MEDICO_DOCENTE:
	                        medico = instanciaMedicoDocente(resultSet);
	                        break;
	                    case RESIDENTE:
	                        medico = instanciaMedicoResidente(resultSet);
	                        break;
	                }

	                return medico;
	            } else {
	                return null; 
	            }
	        }
	    } catch (SQLException e) {
	        throw new SQLException("Erro ao procurar médico", e);
	    }
	}//procurarMedico()

	private static Medico instanciaMedico(ResultSet resultSet) throws SQLException {
		Medico medico = new Medico();
		medico.setNome(resultSet.getString("nome"));
		medico.setCrm(resultSet.getString("crm"));
		medico.setSenha(resultSet.getString("senha"));
		
		return medico;
	}//instanciaMedico()
	
	private static Medico instanciaMedicoDocente(ResultSet resultSet) throws SQLException {
		MedicoDocente medico = new MedicoDocente();
		medico.setNome(resultSet.getString("nome"));
	    medico.setCrm(resultSet.getString("crm"));
	    medico.setSenha(resultSet.getString("senha"));
		medico.setTitulo(resultSet.getString("titulacao"));
		return medico;		
	}//instanciaMedicoDocente()
	
	private static MedicoResidente instanciaMedicoResidente(ResultSet resultSet) throws SQLException {
	    MedicoResidente medico = new MedicoResidente();
	    medico.setNome(resultSet.getString("nome"));
	    medico.setCrm(resultSet.getString("crm"));
	    medico.setSenha(resultSet.getString("senha"));
	    medico.setAnoInicioResidencia(resultSet.getString("anoinicioresidencia"));
	    
	    return medico;
	}//instanciaMedicoResidente()


}//MedicoDAO
