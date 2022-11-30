package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Locacao;

public class LocacaoDao implements ILocacaoDao {

	private GenericDao gDao;
	
	public LocacaoDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String inserirLocacao(Locacao l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO locacao VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, l.getIdLivro().getId());
		ps.setString(2, l.getEmail());
		ps.setString(3, l.getDataIni());
		ps.setString(4, l.getDataFim());
		ps.execute();
		ps.close();
		c.close();
		
		return "Cadastrado com sucesso";
	}

}
