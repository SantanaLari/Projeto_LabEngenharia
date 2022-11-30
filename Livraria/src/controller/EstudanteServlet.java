package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estudante;
import persistence.EstudanteDao;
import persistence.GenericDao;
import persistence.IEstudanteDao;

@WebServlet("/estudante")
public class EstudanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudanteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("curso");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confirmaSenha = request.getParameter("confirmar senha");
		String RA = request.getParameter("RA");
		String botao = request.getParameter("enviar");
		String erro = "";
		String saida = "";
		
		Estudante et = new Estudante();
		 
		GenericDao gDao = new GenericDao();
		IEstudanteDao eDao = new EstudanteDao(gDao);
		
		try {
			if(botao.equals("Enviar")) {
				et = valido(email, senha, confirmaSenha, curso, RA, botao);
				saida = eDao.inserirEstudante(et);
				et = new Estudante();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("estudante.jsp");
			request.setAttribute("estudante", et);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}
	
	private Estudante valido(String email, String senha, String confirmaSenha, String curso, String RA, String botao) throws IOException {
		Estudante et = new Estudante();
		
		if(botao.equals("Enviar")) {
			if(email.equals("") || senha.equals("") || confirmaSenha.equals("") || curso.equals("") || RA.equals("")) {
				throw new IOException("Preencha todos os campos");
			}else {
				et.setEmail(email);
				et.setSenha(senha);
				et.setConfirmaSenha(confirmaSenha);
				et.setCurso(curso);
				et.setRA(RA);
			}
		}
		
		return et;
	}

}
