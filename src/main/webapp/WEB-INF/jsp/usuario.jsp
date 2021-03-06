<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Usuário | Cinema Propeller</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Usuários</span>
		</h1><!-- End Title -->
	
		<!--breadcrum start-->
		<ol class="breadcrumb text-left">
		  <li><a href="/home">Home</a></li>
		  <li class="active">Visualização</li>
		</ol><!--breadcrum end-->
	
		<!-- table card -->
		<section class="row component-section">
		
			<!-- table card title and description -->
			<div class="col-md-3">
				<div id="card">
					<h2>Descrição</h2>
				</div>
				<p>Esta é a tabela de visualização de registros já cadastrados no sistema, aonde
				posso alterar, ou deletar algum registro, caso seja necessário</p>
			</div> <!-- table card title and description end -->
			
			<!-- table card code and example -->
			<div class="col-md-9">
				<div class="component-box">
					<!-- ${ usuario.id } -->
					<div  class="pmd-card pmd-z-depth pmd-card-custom-view">
						<div class="table-responsive">
						<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>NOME</th>
								<th>E-MAIL</th>
								<th>IDADE</th>
								<th>SEXO</th>
								<th>ESTADO CIVÍL</th>
								<th>EDITAR</th>
								<th>EXCLUIR</th>
							</tr>
						</thead>
						<tbody>
						
				<c:forEach var="usuario" items="${usuarios}">
					<tr id="tr_${usuario.id }">
						<td><input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.id }"></td>
						<td id="nome">${ usuario.nome }</td>
						<td id="email">${ usuario.email }</td>
						<td id="idade">${ usuario.idade }</td>
						<td id="sexo">${ usuario.sexo }</td>
						<td id="estadoCivil">${ usuario.estadoCivil }</td>
						<td><button data-target="#form-dialog" data-toggle="modal" class="btn btn-sm pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-primary" type="submit" id="open_modal"><i class="material-icons md-dark pmd-sm">edit</i></button></td>
						<td><button class="btn btn-sm pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-primary" type="submit" id="btn-delete"><i class="material-icons pmd-sm">delete</i></button></td>
					</tr>
				</c:forEach>
				
						</tbody>
					</table>
						</div>
					</div> 
				</div>
			</div> 
		</section> 
	</div>
</div>

<div tabindex="-1" class="modal fade" id="form-dialog" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h2 class="pmd-card-title-text">Alterar Usuário</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield">
						<label for="first-name">Nome Completo</label>
						<input type="hidden" id="idUsuarioModal" name="idUsuarioModal">
						<input type="text" class="mat-input form-control" id="nomeModal" name="nomeModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield">
						<label for="first-name">E-mail</label>
						<input type="text" class="mat-input form-control" id="emailModal" name="emailModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield">
						<label for="first-name">Idade</label>
						<input type="text" class="mat-input form-control" id="idadeModal" name="idadeModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield">
						<label for="first-name">Sexo</label>
						<select class="select-simple form-control pmd-select2" id="sexoModal" name="sexoModal">
							<option value="MASCULINO">Masculino</option>
							<option value="FEMININO">Feminino</option>
						</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield">
						<label for="first-name">Estado Civíl</label>
						<select class="select-simple form-control pmd-select2" id="estadoCivilModal" name="estadoCivilModal">
							<option value="SOLTEIRO">Solteiro</option>
							<option value="CASADO">Casado</option>
							<option value="VIUVO">Viúvo</option>
							<option value="DIVORCIADO">Divorciado</option>
						</select>
					</div>
<!-- 					<div class="form-group pmd-textfield pmd-textfield"> -->
<!-- 						<label for="first-name">Senha</label> -->
<!-- 						<input type="text" class="mat-input form-control" id="senhaModal" name="senhaModal"> -->
<!-- 					</div> -->
				</form>
			</div>
			<div class="pmd-modal-action">
				<button data-dismiss="modal"  class="btn pmd-ripple-effect btn-primary" type="submit">Salvar Alterações</button>
			</div>
		</div>
	</div>
</div>

<jsp:include page="includes/include-footer.jsp"/>
<jsp:include page="includes/include-listagem-scripts.jsp"/>

<script>
		$(document).ready(function() {

			$("#btn-delete").click(function(e) {
				e.preventDefault();

				var idUsuario = $("#idUsuario").val();

				if (confirm("Deseja excluir?")) {
					console.log(idUsuario);

					$.ajax({
						url : window.location + "/delete/" + idUsuario,
						type : "DELETE",
						success : function() {
							$('#tr_' + idUsuario).remove();
						},
						error : function(data) {

						}
					});

				} else {

				}

			});

			$("#open_modal").click(function(e) {
				e.preventDefault();
				$("#idUsuarioModal").val($("#idUsuario").val());
				$("#nomeModal").val($("#nome").text());
				$("#emailModal").val($("#email").text());
				$("#idadeModal").val($("#idade").text());
				$("#sexoModal").val($("#sexo").text());
				$("#estadoCivilModal").val($("#estadoCivil").text());
			});

			$("#btn-update").click(function(e) {

				var usuario = {
					id : $("#idUsuarioModal").val(),
					nome : $("#nomeModal").val(),
					email : $("#emailModal").val(),
					idade : $("#idadeModal").val(),
					sexo : $("#sexoModal").val(),
					estadoCivil : $("#estadoCivilModal").val()
				};
				
				console.log(usuario);
				
				$.ajax({
					method : "PUT",
					contentType : 'application/json',
					url : "/usuario/update/" + $("#idUsuarioModal").val(),
					dataType : "json",
					data : JSON.stringify(usuario),
					success : function(usuario) {
						var objUsuario = new Object();
						objUsuario = JSON.parse(usuario);

						//limpar a tela
						$("#idUsuarioModal").val("");
						$("#nomeModal").val("");
						$("#emailModal").val("");
						$("#idadeModal").val("");
						$("#sexoModal").val("");
						$("#estadoCivilModal").val("");
						console.log("Objeto usuário depois do sucesso: ", objUsuario);
					},
					error : function(errResponse) {
						console.log("error", errResponse);
					}
				});
			});

		});
	</script>

</body>
</html>