package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface IPesquisaDao {
	
	public List<Livro> consultaLivro(String nome) throws SQLException, ClassNotFoundException;
}
