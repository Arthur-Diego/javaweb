<%@page import="java.util.List"%>
<%@page import="clienteservlet.Cliente"%>
<!DOCTYPE html>
<html>
<head>

<script>
	function confirmar(pi) {
		if (window.confirm("Deseja realmente excluir?")) {
			location.href = "cliente?acao=exc&i=" + pi;
		}
	}
	function editar(iedit) {

		location.href = "cliente?acao=edit&i=" + iedit;
	}
</script>
</head>
<body>

	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.print("<h1>" + msg + "</h1>");
		}

		Cliente cli = (Cliente) request.getAttribute("cli");
		String indice = (String) request.getAttribute("iCli");
	%>

	<form action="cliente" method="post">
		<input type="hidden" name="i" value="<%=indice%>" /> 
		<input type="text" value="<%out.print(cli.getEmail());%>" name="email"
			id="nome2" /> 
			<input value="salvar" type="submit" />
	</form>

	<%
		int i = 0;
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		for (Cliente c : lista) {
			out.print(c.getEmail() + "<a href='javascript:confirmar(" + i
					+ ")'>excluir</a><a href='javascript:editar(" + i + ")'>editar</a><br/><br/>");

			i++;
		}
	%>
</body>
</html>