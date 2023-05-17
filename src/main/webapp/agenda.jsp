<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> listaDadosCadastrados = (ArrayList<JavaBeans>) request.getAttribute("listaDados");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="icon" href="./imagens/livroDeContatos.png">
<title>Agenda</title>
</head>
<body>
	<div class="container m-3 col-7">
		<h1>Agenda de Contatos</h1>
		<div class="d-grid gap-2 d-md-block">
			<button class="btn btn-outline-primary btn-sm" type="button"
				onclick="window.location.href='cadastro.html'">Cadastrar
				novo contato</button>
			<button class="btn btn-outline-danger btn-sm" type="button"
				onclick="window.location.href='report'">Relatório</button>
		</div>
		<hr>

		<table class="table table-responsive  table-striped-columns">
			<thead class="table-dark table align-middle ">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>E-mail</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < listaDadosCadastrados.size(); i++) {
				%>
				<tr>
					<!-- Usa um script language com o sinal de igual, obtemos o conteúdo 
				de uma variável. 
				E também, que se usa "%=", não se coloca ';' no final.-->
					<td><%=listaDadosCadastrados.get(i).getIdCode()%></td>
					<td><%=listaDadosCadastrados.get(i).getNome()%></td>
					<td><%=listaDadosCadastrados.get(i).getPhone()%></td>
					<td><%=listaDadosCadastrados.get(i).getEmail()%></td>
					<td>
						<button class="btn btn-warning btn-sm"
							onclick="window.location.href='select?idCode=<%=listaDadosCadastrados.get(i).getIdCode()%>'">
							Editar</button>
						<button class="btn btn-danger btn-sm"
							onclick="window.location.href='javascript: confirmar(<%=listaDadosCadastrados.get(i).getIdCode()%>)'">Apagar</button>
					</td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>

	</div>
	<script src="./script/excluir.js"></script>
</body>
</html>