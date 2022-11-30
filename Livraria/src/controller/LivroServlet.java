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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		Livro l = new Livro();
		
		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);
	
		try {
			if(botao.equals("Salvar")) {
				l = valido(id, nome, autor, editora, ano, area, caminho, disponibilidade, botao);
				saida = lDao.inserirLivro(l);
				l = new Livro();
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("livro.jsp");
			request.setAttribute("l", l);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	private Livro valido(String id, String nome, String autor, String editora, String ano, 
			String area, String caminho, String disponibilidade, String botao) {
		Livro l = new Livro();
		
		l.setId(Integer.parseInt(id));
		l.setNome(nome);
		l.setAutor(autor);
		l.setEditora(editora);
		l.setAno(Integer.parseInt(ano));
		l.setArea(area);
		l.setCaminho(caminho);
		l.setDisponibilidade(disponibilidade);
		
		return l;
		
	}
}
