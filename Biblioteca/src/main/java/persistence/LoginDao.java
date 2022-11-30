package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Login;

public class LoginDao implements ILoginDao {
	
	private GenericDao gDao;
	
	public LoginDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String validaLogin(Login l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "exec p_validaLogin @e = ?, @s = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, l.getEmail());
		ps.setString(2, l.getSenha());
		ps.execute();
		ps.close();
		c.close();
		
		return "Sucesso";
	}

}
