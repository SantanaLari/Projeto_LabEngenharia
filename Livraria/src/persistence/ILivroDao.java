package persistence;

import java.sql.SQLException;

import model.Livro;

public interface ILivroDao {
	
	public String inserirLivro(Livro l) throws SQLException,  ClassNotFoundException;
}
