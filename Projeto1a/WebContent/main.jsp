<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page import="projeto1.*,java.util.*"%>
</head>
<body>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		List<Nota> notas = (List<Nota>) request.getAttribute("notas");
	%>

	<h1>
		Olá,<%=usuario.getNome()%>, tudo bem?
	</h1>

	<h3>Nova nota</h3>
	<form action="./SendNote" method="post">
		Título: <input type="text" name="titulo"> </br> Mensagem: <input
			type="text" name="msg"> </br> Deadline: <input type="text"
			name="deadline"> </br> <input type="submit" name="nota"> <input
			type="hidden" name="user_id" value="<%=usuario.getId()%>">
	</form>
	</br>
	<h2>Notas</h2>
	<table>
		<tr>
			<td><h4>Ordenar por:</h4></td>
			<td><form action="./OrderByDeadline" method="post">
					<button type="submit" name="orderByDeadline"
						value="<%=usuario.getId()%>">Deadline</button>
				</form></td>
			<td><form action="./OrderByTitle" method="post">
					<button type="submit" name="orderByTitle"
						value="<%=usuario.getId()%>">Title</button>
				</form></td>
		</tr>
	</table>
	
	<h2>Filtro por mensagem:</h2>
	<form action="./Filter" method="post">
		Procurar: <input type="text" name="word"> 
			 <input type="submit" name="filtro"> 
			 <input type="hidden" name="user_id" value="<%=usuario.getId()%>">
	</form>
	<table border='2'>
		<tr>
			<td>Title</td>
			<td>Message</td>
			<td>Date</td>
			<td>Deadline</td>
		</tr>
		<%
			for (Nota nota : notas) {
				out.println("<tr><td>" + nota.getTitle() + "</td>");
				out.println("<td>" + nota.getMensage() + "</td>");
				out.println("<td>" + nota.getDate().getTime().toString() + "</td>");
				out.println("<td>" + nota.getDeadline().getTime().toString() + "</td>");
				out.println(
						"<td><form action=\"./DeleteNote\" method=\"post\"><button type=\"submit\" name=\"delete\" value=\""
								+ nota.getId() + "\">APAGAR </button></td></form>");
				out.println(
						"<td><form action=\"./EditNote\" method=\"post\"><button type=\"submit\" name=\"edit\" value=\""
								+ nota.getId() + "\">EDITAR </button></td></tr></form>");

			}
		%>
	
</body>
</html>