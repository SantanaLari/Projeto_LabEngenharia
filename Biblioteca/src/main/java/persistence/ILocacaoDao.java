package persistence;

import java.sql.SQLException;

import model.Locacao;

public interface ILocacaoDao {

	public String inserirLocacao(Locacao l) throws SQLException, ClassNotFoundException;
	
}
