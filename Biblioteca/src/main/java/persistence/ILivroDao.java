package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Livro;

public interface ILivroDao {

	public String insereLivro(Livro l) throws SQLException, ClassNotFoundException;
	public String atualizaLivro(Livro l) throws SQLException, ClassNotFoundException;
	public String excluiLivro(Livro l) throws SQLException, ClassNotFoundException;
	public String retornoLivro(Livro l) throws SQLException, ClassNotFoundException;
	public Livro consultaNome(Livro l) throws SQLException, ClassNotFoundException;
	public Livro consultaArea(Livro l) throws SQLException, ClassNotFoundException;
	public List<Livro> consultaLivros() throws SQLException, ClassNotFoundException;
	
}
