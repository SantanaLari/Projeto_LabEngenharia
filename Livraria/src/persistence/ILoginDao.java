package persistence;

import java.sql.SQLException;

import model.Login;

public interface ILoginDao {
	
	public String validaLogin(Login l) throws SQLException, ClassNotFoundException;
	
}
