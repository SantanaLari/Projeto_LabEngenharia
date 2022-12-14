package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
// [START multipart_includes]
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
// [END simple_includes]
import javax.mail.internet.MimeMultipart;
// [END multipart_includes]
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TesteServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String type = req.getParameter("type");
		String email = req.getParameter("email");
		if (type != null && type.equals("multipart")) {
			resp.getWriter().print("Sending HTML email with attachment.");
			sendMultipartMail(email);
		} else {
			resp.getWriter().print("Sending simple email.");
			sendSimpleMail();
		}
	}

	private void sendSimpleMail() {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("user@example.com", "Mr. User"));
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
