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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String dataIni = request.getParameter("dataIni");
		String dataFim = request.getParameter("dataFim");
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Locacao locacao = new Locacao();
		
		GenericDao gDao = new GenericDao();
		ILocacaoDao lDao = new LocacaoDao(gDao);
		
		try {
			if(botao.equals("Alugar")) {
				locacao = valido(id, email, dataIni, dataFim, botao);
				saida = lDao.inserirLocacao(locacao);
				locacao = new Locacao();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("locacao.jsp");
			request.setAttribute("locacao", locacao);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
		
	}
	
	private Locacao valido(String id, String email, String dataIni, String dataFim, String botao) throws IOException{
		Livro l = new Livro();
		Locacao locacao = new Locacao();
		
		l.setId(Integer.parseInt(id));
		locacao.setIdLivro(l);
		
		locacao.setEmail(email);
		locacao.setDataIni(dataIni);
		locacao.setDataFim(dataFim);
		
		return locacao;
		
	}

}
