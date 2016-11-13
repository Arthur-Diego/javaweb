<%@page import="java.util.List"%>
<%@page import="clienteservlet.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div>${requestScope.msg}</div>
	<%-- <%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.print("<h1>" + msg + "</h1>");
		}

		Cliente cli = (Cliente) request.getAttribute("cli");
		String indice = (String) request.getAttribute("iCli");
	%>
 --%>
	<form action="cliente" method="post">
		<input type="hidden" name="i" value="${requestScope.iCli}" /> <input
			type="text" value="${requestScope.cli.email}" name="email"
			id="nome2" /> <input value="salvar" type="submit" />
	</form>

	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Ação</th>
		</tr>
		<c:set var="i" value="0"></c:set>
		<c:forEach items="${requestScope.lista}" var="c">
			<%-- <%
				int i = 0;
					List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
			%> --%>
			<tr>
				<td>${c.email}</td>
				<td><a href='javascript:confirmar(" + ${i} + ")'>excluir</a><a href='javascript:editar(" + ${i} + ")'>editar</a></td>
			</tr>
			<%-- <%
				for (Cliente c : lista) {
						out.print("<tr>");
						out.print("<td>" + c.getEmail() + "</td>");
						out.print("<td></td>");
						out.print("<td></td>");
						i++;
						out.print("</tr>");
					}
			%> --%>
		</c:forEach>
		<c:set var="i" value="${i+1}"></c:set>
	</table>
</body>
</html>