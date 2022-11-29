package persistence;

import java.sql.SQLException;

import model.Locacao;

public interface ILocacaoDao {

	public String alocar(Locacao l) throws SQLException, ClassNotFoundException;
	
}
