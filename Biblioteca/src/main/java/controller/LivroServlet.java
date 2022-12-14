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
import persistence.GenericDao;
import persistence.ILivroDao;
import persistence.LivroDao;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String ano = request.getParameter("ano");
		String area = request.getParameter("area");
		String caminho = request.getParameter("caminho");
		String disponibilidade = request.getParameter("disponibilidade");
		String botao = request.getParameter("botao");
	
		String erro = "";
		String saida = "";
		
		Livro livro = new Livro();
		List<Livro> listaLivro = new ArrayList<Livro>();
		List<Livro> listaIndisponivel = new ArrayList<Livro>();
		
		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);
	
		try {
			if(botao.equals("Visualizar")) {
				listaLivro = lDao.visualizaLivros();
				listaIndisponivel = lDao.visualizaLivrosIndisponiveis();
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("listaLivro", listaLivro);
			request.setAttribute("listaIndisponivel", listaIndisponivel);	
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String ano = request.getParameter("ano");
		String disponibilidade = request.getParameter("disponibilidade");
		String area = request.getParameter("area");
		String caminho = request.getParameter("caminho");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";

		Livro livro = new Livro();

		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);

		try {
			if (botao.contains("Salvar")) {
				livro = valido(id, nome, autor, editora, ano, disponibilidade, area, caminho, botao);
				saida = lDao.insereLivro(livro);
				livro = new Livro();
			}
			if (botao.contains("Atualizar")) {
				livro = valido(id, nome, autor, editora, ano, disponibilidade, area, caminho,botao);
				saida = lDao.atualizaLivro(livro);
				livro = new Livro();
			}
			if (botao.contains("Deletar")) {
				livro = valido(id, nome, autor, editora, ano, disponibilidade, area, caminho, botao);
				saida = lDao.excluiLivro(livro);
				livro = new Livro();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("livro.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}

	}

	private Livro valido(String id, String nome, String autor, String editora, String ano, String disponibilidade,
			String area, String caminho, String botao) throws IOException {
		Livro l = new Livro();

		if (botao.equals("Cadastrar")) {
			if (id.equals("") || nome.equals("") || autor.equals("") || editora.equals("") || ano.equals("")
					|| disponibilidade.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNome(nome);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
				l.setArea(area);
				l.setCaminho(caminho);
			}
		}
		if (botao.equals("Atualizar")) {
			if (id.equals("") || nome.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNome(nome);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
				l.setArea(area);
				l.setCaminho(caminho);
			}
		}
		if (botao.equals("Deletar")) {
			if (id.equals("") || nome.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNome(nome);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
				l.setArea(area);
				l.setCaminho(caminho);
			}
		}
		return l;
	}

}
