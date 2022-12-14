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
	public String insereLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO livro VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.setString(2,l.getNome());
		ps.setString(3,l.getAutor());
		ps.setString(4,l.getEditora());
		ps.setInt(5,l.getAno());
		ps.setString(6,l.getDisponibilidade());
		ps.setString(7,l.getArea());
		ps.setString(8,l.getCaminho());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro inserido.";
	}

	@Override
	public String atualizaLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE livro SET nome = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,l.getNome());
		ps.setInt(2,l.getId());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro atualizado.";
	}

	@Override
	public String excluiLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE livro WHERE id = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro excluido.";
	}


	@Override
	public String retornoLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "EXEC p_devolucao (?) ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro devolvido.";
	}

	@Override
	public List<Livro> visualizaLivros() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT nome, autor, disponibilidade FROM livro";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Livro l = new Livro();
			l.setNome(rs.getString("nome"));
			l.setAutor(rs.getString("autor"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			
			livros.add(l);
		}
		rs.close();
		ps.close();
		c.close();
		
		return livros;
	}

	@Override
	public List<Livro> visualizaLivrosIndisponiveis() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT nome, autor, disponibilidade FROM livro WHERE disponibilidade != 'sim'";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Livro l = new Livro();
			l.setNome(rs.getString("nome"));
			l.setAutor(rs.getString("autor"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			
			livros.add(l);
		}
		rs.close();
		ps.close();
		c.close();
		
		return livros;
	}
	
}
