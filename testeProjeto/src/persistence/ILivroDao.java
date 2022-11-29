package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface ILivroDao {
	
	public List<Livro> consultaLivros() throws SQLException, ClassNotFoundException;
}
