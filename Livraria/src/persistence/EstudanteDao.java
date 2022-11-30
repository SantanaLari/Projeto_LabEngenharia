package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Estudante;

public class EstudanteDao implements IEstudanteDao {

	private GenericDao gDao;
	
	public EstudanteDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String inserirEstudante(Estudante et) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "exec validaEstudante @email = ?, @senha = ?, @confirmaSenha = ?, @curso = ?, @RA = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, et.getEmail());
		ps.setString(2, et.getSenha());
		ps.setString(3, et.getConfirmaSenha());
		ps.setString(4, et.getCurso());
		ps.setString(5, et.getRA());
		ps.execute();
		ps.close();
		c.close();
		
		return "Cadastrado com sucesso";
	}

}
