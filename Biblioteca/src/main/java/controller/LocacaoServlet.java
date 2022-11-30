package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			if (botao.equals("Alugar")) {
				locacao = valido(id, email, dataIni, dataFim, botao);
				saida = lDao.inserirLocacao(locacao);
				locacao = new Locacao();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("locacao.jsp");
			request.setAttribute("locacao", locacao);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}

	/*	String type = request.getParameter("type");
		if (type != null && type.equals("multipart")) {
			response.getWriter().print("Sending HTML email with attachment.");
			sendMultipartMail(email);
		} else {
			response.getWriter().print("Sending simple email.");
			sendSimpleMail();
		}*/
		
	}

	private Locacao valido(String id, String email, String dataIni, String dataFim, String botao) throws IOException {
		Livro l = new Livro();
		Locacao locacao = new Locacao();

		l.setId(Integer.parseInt(id));
		locacao.setIdLivro(l);

		locacao.setEmail(email);
		locacao.setDataIni(dataIni);
		locacao.setDataFim(dataFim);

		return locacao;

	}

	private void sendSimpleMail() {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("email", "Sr(a). "));
			msg.setSubject("Your Example.com account has been activated");
			msg.setText("This is a test");
			Transport.send(msg);
		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
		// [END simple_example]
	}

	private void sendMultipartMail(String email) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "...";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("email", "Sr(a). "));
			msg.setSubject("Your Example.com account has been activated");
			msg.setText(msgBody);

			// [START multipart_example]
			String htmlBody = ""; // ...
			byte[] attachmentData = null; // ...
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html");
			mp.addBodyPart(htmlPart);

			MimeBodyPart attachment = new MimeBodyPart();
			InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentDataStream, "application/pdf");
			mp.addBodyPart(attachment);

			msg.setContent(mp);

			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
	
}
