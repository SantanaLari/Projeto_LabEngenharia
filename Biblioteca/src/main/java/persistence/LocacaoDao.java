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
	public String alocar(Locacao l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "EXEC p_locacao (?) ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,l.getId());
		ps.execute();
		ps.close();
		c.close();
		return "Locação realizada com sucesso.";
	}

}
