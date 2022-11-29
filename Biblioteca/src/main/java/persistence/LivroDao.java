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
		String sql = "INSERT INTO livro VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.setString(2,l.getNomeCompleto());
		ps.setString(3,l.getAutor());
		ps.setString(4,l.getEditora());
		ps.setInt(5,l.getAno());
		ps.setString(6,l.getDisponibilidade());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro inserido.";
	}

	@Override
	public String atualizaLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE livro SET nomeCompleto = ?, resumo = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,l.getNomeCompleto());
		ps.setInt(3,l.getId());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro atualizado.";
	}

	@Override
	public String excluiLivro(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE livro";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.execute();
		ps.close();
		c.close();
		
		return "Livro excluido.";
	}

	@Override
	public Livro consultaNome(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT nome, disponibilidade, caminho FROM fn_livronome(?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,l.getNomeCompleto());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			l.setNomeCompleto(rs.getString("nomeCompleto"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			l.setCaminho(rs.getString("caminho"));
		}
		ps.execute();
		ps.close();
		c.close();
		
		return l;
	}

	@Override
	public Livro consultaArea(Livro l) throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT nome, disponibilidade, caminho FROM fn_livroarea(?) ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,l.getArea());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			l.setNomeCompleto(rs.getString("nomeCompleto"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			l.setCaminho(rs.getString("caminho"));

			livros.add(l);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return l;
	}
	
	@Override
	public List<Livro> consultaLivros() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT id, nomeCompleto, disponibilidade FROM livro";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Livro l = new Livro();
			l.setNomeCompleto(rs.getString("nomeCompleto"));
			l.setDisponibilidade(rs.getString("disponibilidade"));
			l.setCaminho(rs.getString("caminho"));

			livros.add(l);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return livros;
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

}
