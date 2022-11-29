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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Livro l = new Livro();
		
		GenericDao gDao = new GenericDao();
		ILivroDao lDao = new LivroDao(gDao);
		List<Livro> listLivro = new ArrayList<Livro>();
		
		try {
		//	if(botao.equals("Salvar")) {
				listLivro = lDao.consultaLivros();
		//	}
		}catch(SQLException | ClassNotFoundException e) {
			
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("l", l);
			request.setAttribute("listLivro", listLivro);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

}
