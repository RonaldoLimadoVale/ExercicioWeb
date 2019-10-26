package br.unipe.web.java.boot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloJoseServlet {

	@SuppressWarnings("serial")
	@WebServlet(name = "JoseServlet", urlPatterns = { "/jose" })// o /fujioka eh um endpoint
	public class HelloFujiokaServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String parametro = req.getParameter("nome");
			if (parametro == null)
				parametro = req.getAttribute("nome").toString();
			String idade = req.getParameter("idade");
			ServletOutputStream out = resp.getOutputStream();
			String saida = "Hello Jose " + parametro + " " + idade;
			out.write(saida.getBytes());
			out.flush();
			out.close();
		}

	}
}
