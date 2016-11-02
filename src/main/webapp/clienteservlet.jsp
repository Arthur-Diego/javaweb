<%@page import="java.util.List"%>
<%@page import="clienteservlet.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			String msg = (String)request.getAttribute("msg");
			if(msg != null){
				out.print("<h1>"+msg+"</h1>");
			}
	
	%>
	
	<form action="cliente" method="post">
		<input type="text" name="email" id="nome2" /> <input value="salvar" type="submit" />
	</form>
	
	<%
	
	int i = 0;
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		for (Cliente c : lista) {
			out.print(c.getEmail()+"<a href='cliente?i="+i+"'>excluir</a><br/>");
			
			i++;
		}
	%>
</body>
</html>