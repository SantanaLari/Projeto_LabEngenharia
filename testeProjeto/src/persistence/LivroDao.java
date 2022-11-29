package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;

public class LivroDao implements ILivroDao {

	private GenericDao gDao;
	
	public LivroDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public List<Livro> consultaLivros() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT nome, disponibilidade, caminho FROM livro");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Livro l = new Livro();
			
			l.setNomeCompleto(rs.getString("nome"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			l.setCaminho(rs.getString("caminho"));
			
			livros.add(l);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return livros;
	}

}
