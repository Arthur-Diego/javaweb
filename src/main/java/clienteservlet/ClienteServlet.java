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

	// private List<Cliente> cliente = new ArrayList<>();
	ClienteService service;
	
	@Override
	public void init() throws ServletException {
		service = new ClienteService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//System.out.println(req.changeSessionId());
		/*System.out.println(req.getAuthType());
		System.out.println(req.getCharacterEncoding());
		System.out.println(req.getContentType());
		System.out.println(req.getContextPath());
		System.out.println(req.getLocalAddr());
		System.out.println(req.getLocalName());
		System.out.println(req.getLocalPort());
		System.out.println(req.getMethod());
		System.out.println(req.getPathInfo());
		System.out.println(req.getPathTranslated());
		System.out.println(req.getProtocol());
		System.out.println(req.getQueryString());
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getRemotePort());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getAttributeNames());
		System.out.println(req.getServletContext().getAttributeNames());*/
		
		
		
		Cliente cli = new Cliente();
		String indice = "-1";
		String i = req.getParameter("i");
		if(i!=null && i!=""){
			indice= i;
		}
		String acao = req.getParameter("acao");
		
		if(i!= null && i != "" && acao != null && acao != ""){
			if(acao.equals("exc")){
				service.excluir(Integer.parseInt(i));
			}
			if(acao.equals("edit")){
			cli = service.buscarPorIndice(Integer.parseInt(i));
			}
		}
		
//		if(i != null){
//			service.excluir(Integer.parseInt(i));
//		}
		
		RequestDispatcher requestD = req.getRequestDispatcher("clienteservlet.jsp");
		req.setAttribute("lista", service.getLista());
		req.setAttribute("cli", cli);
		req.setAttribute("iCli", indice);
		// System.out.println("Olá mundo: Get");

		requestD.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente();

		// String nome = (String) req.getAttribute("nome");
		cliente.setEmail((String) req.getParameter("email"));
		String indice = req.getParameter("i");
		
		service.salvar(indice,cliente);
		
		cliente = new Cliente();
		cliente.setEmail("");

		// this.cliente.add(cliente);
		RequestDispatcher requestD = req.getRequestDispatcher("clienteservlet.jsp");
		req.setAttribute("msg", "Cadastro efetudado com sucesso!!!");
		req.setAttribute("lista", service.getLista());
		req.setAttribute("cli", cliente);
		req.setAttribute("iCli", "-1");
		
		requestD.forward(req, resp);
		// resp.sendRedirect("cliente");
		// resp.getWriter().print("Chamou metodo post " + email);
		System.out.println("Olá mundo: Post");
	}

}
