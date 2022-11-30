package persistence;

import java.sql.SQLException;

import model.Estudante;

public interface IEstudanteDao {
	
	public String inserirEstudante(Estudante et) throws SQLException, ClassNotFoundException;
}
