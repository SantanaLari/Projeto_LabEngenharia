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
import persistence.IPesquisaDao;
import persistence.PesquisaDao;

@WebServlet("/pesquisa")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesquisaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Livro livro = new Livro();
		List<Livro> listaLivro = new ArrayList<Livro>();
		
		GenericDao gDao = new GenericDao();
		IPesquisaDao pDao = new PesquisaDao(gDao);
		
		try {
			if(botao.equals("Pesquisar")) {
				listaLivro = pDao.consultaLivro(nome);
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
			request.setAttribute("livro", livro);
			request.setAttribute("listaLivro", listaLivro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

}
