package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioDao implements IFuncionarioDao {

	private GenericDao gDao;
	
	public FuncionarioDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String inserirFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "exec validaFuncionario @email = ?, @senha = ?, @confirmaSenha = ?, @cargo = ?, @RF = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, f.getEmail());
		ps.setString(2, f.getSenha());
		ps.setString(3, f.getConfirmaSenha());
		ps.setString(4, f.getCargo());
		ps.setString(5, f.getRF());
		ps.execute();
		ps.close();
		c.close();
		
		return "Cadastrado com sucesso";
	}

}
