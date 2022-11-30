package persistence;

import java.sql.SQLException;

import model.Funcionario;

public interface IFuncionarioDao {

	public String inserirFuncionario(Funcionario f) throws SQLException, ClassNotFoundException;
}
