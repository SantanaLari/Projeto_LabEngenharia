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

@WebServlet("/pesquisa")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesquisaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String id = request.getParameter("id");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Locacao locacao = new Locacao();
		Livro livro = new Livro();
		
		GenericDao gDao = new GenericDao();
		ILocacaoDao qDao = new LocacaoDao(gDao);

		try {
			if(botao.contains("Área do Livro")) {
				livro.setId(Integer.parseInt(id));
				locacao.setLivro(livro);
				saida = qDao.alocar(locacao);
			}
			if(botao.contains("Nome do Livro")) {
				livro.setId(Integer.parseInt(id));
				locacao.setLivro(livro);
				saida = qDao.alocar(locacao);
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	
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
			if(botao.contains("Detalhes")) {
				livro.setId(Integer.parseInt(id));
				locacao.setLivro(livro);
				saida = qDao.alocar(locacao);
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("emprestimo.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	
	}

}
