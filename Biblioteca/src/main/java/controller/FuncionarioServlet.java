package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.GenericDao;
import persistence.IFuncionarioDao;

@WebServlet("/funcionario")
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cargo = request.getParameter("cargo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confirmaSenha = request.getParameter("confirmar senha");
		String RF = request.getParameter("RF");
		String botao = request.getParameter("enviar");
		String erro = "";
		String saida = "";

		Funcionario f = new Funcionario();

		GenericDao gDao = new GenericDao();
		IFuncionarioDao fDao = new FuncionarioDao(gDao);

		try {
			if (botao.equals("Enviar")) {
				f = valido(email, senha, confirmaSenha, cargo, RF, botao);
				saida = fDao.inserirFuncionario(f);
				f = new Funcionario();
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
			request.setAttribute("funcionario", f);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}

	}

	private Funcionario valido(String email, String senha, String confirmaSenha, String cargo, String RF, String botao)
			throws IOException {
		Funcionario f = new Funcionario();

		if (botao.equals("Enviar")) {
			if (email.equals("") || senha.equals("") || confirmaSenha.equals("") || cargo.equals("") || RF.equals("")) {
				throw new IOException("Preencha todos os campos");
			} else {
				f.setEmail(email);
				f.setSenha(senha);
				f.setConfirmaSenha(confirmaSenha);
				f.setCargo(cargo);
				f.setRF(RF);
			}
		}

		return f;
	}

}
