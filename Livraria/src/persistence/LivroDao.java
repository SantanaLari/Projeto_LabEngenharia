package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Livro;

public class LivroDao implements ILivroDao {

	private GenericDao gDao;
	
	public LivroDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String inserirLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO livro VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, l.getId());
		ps.setString(2, l.getNome());
		ps.setString(3, l.getAutor());
		ps.setString(4, l.getEditora());
		ps.setInt(5, l.getAno());
		ps.setString(6, l.getArea());
		ps.setString(7, l.getCaminho());
		ps.setString(8, l.getDisponibilidade());
		ps.execute();
		ps.close();
		c.close();
		
		return "Cadastrado com sucesso";
	}
	
	
}
