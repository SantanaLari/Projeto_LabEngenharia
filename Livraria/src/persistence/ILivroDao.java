package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface ILivroDao {
	
	public String inserirLivro(Livro l) throws SQLException,  ClassNotFoundException;
	public List<Livro> visualizaLivros() throws SQLException, ClassNotFoundException;
	public List<Livro> visualizaLivrosIndisponiveis() throws SQLException, ClassNotFoundException;
	
}
