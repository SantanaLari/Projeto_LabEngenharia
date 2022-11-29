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
import persistence.ILivroDao;
import persistence.ILocacaoDao;
import persistence.LivroDao;
import persistence.LocacaoDao;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroServlet() {
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
				if(botao.contains("�rea do Livro")) {
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
		String nomeCompleto = request.getParameter("nomeCompleto");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String ano = request.getParameter("ano");
		String disponibilidade = request.getParameter("disponibilidade");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";

		Livro livro = new Livro();

		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);

		try {
			if (botao.contains("Cadastrar")) {
				livro = valido(id, nomeCompleto,  autor, editora, ano, disponibilidade, botao);
				saida = lDao.insereLivro(livro);
				livro = new Livro();
			}
			if (botao.contains("Atualizar")) {
				livro = valido(id, nomeCompleto,  autor, editora, ano, disponibilidade, botao);
				saida = lDao.atualizaLivro(livro);
				livro = new Livro();
			}
			if (botao.contains("Deletar")) {
				livro = valido(id, nomeCompleto,  autor, editora, ano, disponibilidade, botao);
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
	
	private Livro valido(String id, String nomeCompleto, String autor, String editora, String ano, String disponibilidade, String botao) throws IOException {
		Livro l = new Livro();

		if(botao.equals("Cadastrar")) {
			if(id.equals("") || nomeCompleto.equals("")|| autor.equals("")|| editora.equals("")|| ano.equals("")|| disponibilidade.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNomeCompleto(nomeCompleto);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
			}
		}
		if(botao.equals("Atualizar")) {
			if(id.equals("") || nomeCompleto.equals("")|| autor.equals("")|| editora.equals("")|| ano.equals("")|| disponibilidade.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNomeCompleto(nomeCompleto);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
			}
		}
		if(botao.equals("Deletar")) {
			if(id.equals("") || nomeCompleto.equals("")|| autor.equals("")|| editora.equals("")|| ano.equals("")|| disponibilidade.equals("")) {
				throw new IOException("Por favor, preencha todos os campos.");
			} else {
				l.setId(Integer.parseInt(id));
				l.setNomeCompleto(nomeCompleto);
				l.setAutor(autor);
				l.setEditora(editora);
				l.setAno(Integer.parseInt(ano));
				l.setDisponibilidade(disponibilidade);
			}
		}
		return l;
	}

}
