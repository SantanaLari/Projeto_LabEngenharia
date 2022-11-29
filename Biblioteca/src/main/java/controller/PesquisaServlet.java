package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Livro;
import model.Locacao;
import persistence.GenericDao;
import persistence.ILivroDao;
import persistence.ILocacaoDao;
import persistence.LivroDao;
import persistence.LocacaoDao;

@WebServlet("/pesquisa")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PesquisaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";

		Livro l = new Livro();
		List<Livro> livros = new ArrayList<Livro>();

		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);

		try {
			if (botao.contains("Área do Livro")) {
				livros = lDao.consultaArea(l);
			}
			if (botao.contains("Nome do Livro")) {
				l = valido(nome, botao);
				l = lDao.consultaNome(l);
				livros.add(l);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("livropesquisa.jsp");
			request.setAttribute("l", l);
			request.setAttribute("livros", livros);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";

		Locacao locacao = new Locacao();
		Livro livro = new Livro();
		List<Livro> livros = new ArrayList<Livro>();

		GenericDao gDao = new GenericDao();
		ILocacaoDao qDao = new LocacaoDao(gDao);
		ILivroDao lDao = new LivroDao(gDao);

		try {
			livros = lDao.consultaLivros();
			if (botao.contains("Detalhes")) {
				livro.setId(Integer.parseInt(id));
				locacao.setLivro(livro);
				saida = qDao.alocar(locacao);

			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("livros", livros);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}

	}

	private Livro valido(String nome, String botao) throws IOException {

		Livro l = new Livro();

		if (botao.equals("Nome do Livro")) {
			if (nome.equals("")) {
				throw new IOException("Preencher o campo");
			} else {
				l.setNomeCompleto(nome);
			}
		}
		return l;

	}
}
