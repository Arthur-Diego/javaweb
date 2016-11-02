package clienteservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

	private List<Cliente> cliente = new ArrayList<>();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		RequestDispatcher requestD = req.getRequestDispatcher("clienteservlet.jsp");
		req.setAttribute("lista", this.cliente);
		//System.out.println("Olá mundo: Get");
		
		requestD.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente();

		//String nome = (String) req.getAttribute("nome");
		cliente.setEmail( (String)req.getParameter("email"));

		this.cliente.add(cliente);
		RequestDispatcher requestD = req.getRequestDispatcher("clienteservlet.jsp");
		req.setAttribute("msg", "Cadastro efetudado com sucesso!!!");
		req.setAttribute("lista", this.cliente);
		
		
		requestD.forward(req, resp);
		//resp.sendRedirect("cliente");
		//resp.getWriter().print("Chamou metodo post " + email);
		System.out.println("Olá mundo: Post");
	}

}
