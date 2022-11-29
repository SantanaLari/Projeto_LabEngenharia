package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Livro;
import model.Locacao;
import persistence.GenericDao;
import persistence.ILocacaoDao;
import persistence.LocacaoDao;

@WebServlet("/locacao")
public class LocacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LocacaoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Locacao locacao = new Locacao();
		Livro livro = new Livro();
		
		GenericDao gDao = new GenericDao();
		ILocacaoDao qDao = new LocacaoDao(gDao);

		try {
			if(botao.contains("Alocar")) {
				livro.setId(Integer.parseInt(id));
				locacao.setLivro(livro);
				saida = qDao.alocar(locacao);
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("emprestimo.jsp");
			request.setAttribute("locacao", locacao);
			request.setAttribute("livro", livro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

}
