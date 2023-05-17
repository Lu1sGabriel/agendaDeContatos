<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Editar Contato</title>
</head>
<body>
	<div class="container m-3 col-4">
		<h1>Editar Contato</h1>
		<hr>
		<form name="formCadastro" action="update">
			<div class="form-floating mb-3 col-2">
				<input type="hidden" class="form-control" id="floatingPassword"
					readonly="readonly" name="inputIdCode"
					value="<%out.print(request.getAttribute("inputIdCode"));%>">
				<label for="floatingPassword">IdCode</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="floatingInput"
					name="cadastroNome"
					value="<%out.print(request.getAttribute("cadastroNome"));%>">
				<label for="floatingInput">Nome</label>
			</div>

			<div class="form-floating mb-3 col-4">
				<input type="tel" class="form-control" id="floatingPassword"
					name="cadastroPhone"
					value="<%out.print(request.getAttribute("cadastroPhone"));%>">
				<label for="floatingPassword">Telefone</label>
			</div>

			<div class="form-floating mb-3">
				<input type="email" class="form-control" id="floatingPassword"
					name="cadastroEmail"
					value="<%out.print(request.getAttribute("cadastroEmail"));%>">
				<label for="floatingPassword">Email</label>
			</div>

			<div class="d-grid gap-2 d-md-block">
				<button class="btn btn-primary" type="button" value="Salvar"
					onclick="validar()">Salvar</button>
			</div>
		</form>
	</div>
	<script src="./script/script.js"></script>
</body>
</html>