<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Listagem de Filmes</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Filmes</span>
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
					<div  class="pmd-card pmd-z-depth pmd-card-custom-view">
						<div class="table-responsive">
						<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
<!-- 								<th>ID</th> -->
								<th>NOME</th>
								<th>GÊNERO</th>
								<th>SINOPSE</th>
								<th>DURAÇÃO</th>
								<th>STATUS</th>
								<th>SEÇÕES</th>
							</tr>
						</thead>
						<tbody>
						
					<c:forEach var="filme" items="${filmes}">
						<tr>
							<td></td>
							<input type="hidden" id="idFilme" name="idFilme">
<%-- 							<td id="idFilme">${filme.id }</td> --%>
							<td id="nome">${ filme.nome }</td>
							<td id="genero">${ filme.genero }</td>
							<td><a href="#" data-target="#bs-dialog" data-toggle="modal"><i class="material-icons md-dark pmd-sm">content_paste</i></a></td>
							<td id="duracao">${ filme.duracao }</td>
							<c:if test="${filme.status } == TRUE">
							<td id="status">Filme em Lançamento</td>
							</c:if>
							<td id="status">Filme fora de Lançamento</td>
							<td><a href="/filme/secoes"><i class="material-icons md-dark pmd-sm">personal_video</i></a></td>
						</tr>
				</c:forEach>
						
						</tbody>
					</table>
						</div>
					</div> <!-- table card example end -->
				</div>
			</div> <!-- table card code and example end -->
		</section> <!-- table card end -->
	</div>

</div>

<div tabindex="-1" class="modal fade" id="bs-dialog" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
<%-- 				<p>${filme.sinopse }</p> --%>
				<p>jkhjkhjk</p>
			</div>
		</div>
	</div>
</div>

<div tabindex="-1" class="modal fade" id="form-dialog" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h2 class="pmd-card-title-text">Alterar Filme</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Nome</label>
						<input type="hidden" id="idFilmeModal" name="idFilmeModal">
						<input type="text" class="mat-input form-control" id="nomeModal" name="nomeModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Gênero</label>
						<input type="text" class="mat-input form-control" id="generoModal" name="generoModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Duração</label>
						<input type="text" class="mat-input form-control" id="duracaoModal" name="duracaoModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Tipo</label>
						<input type="text" class="mat-input form-control" id="tipoModal" name="tipoModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label class="control-label">Sinopse</label>
						<textarea required class="form-control" id="sinopseModal" name="sinopseModal"></textarea>
					</div>
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

		var tableRow = $(this).closest("tr");
		var idFilme = tableRow.find("#idFilme").text();
		if (confirm("Deseja excluir?")) { 

			console.log(idUsuario);
			$.ajax({
				url : "/filme/delete-usuario",
				type : "DELETE",
				data : {
					idFilme : idFilme
				},
				success : function(data) {
					tableRow.remove();
				},
				error : function(data) {
					
				}
			});

		} else {
			
		}


	});

});

</script>


<script>

$(document).ready(function() {

	$("#btn-update").click(function(e) {
		e.preventDefault();
	
		var idFilme = $(this).closest("tr").find("#idFilme").text();
		var nome = $(this).closest("tr").find("#nome").text();
		var genero = $(this).closest("tr").find("#genero").text();
		var duracao = $(this).closest("tr").find("#duracao").text();
		var tipo = $(this).closest("tr").find("#tipo").text();
		var sinopse = $(this).closest("tr").find("#sinopse").text();
		
		$("#idUsuarioModal").val(idUsuario);
		$("#nomeModal").val(nome);
		$("#generoModal").val(genero);
		$("#duracaoModal").val(duracao);
		$("#tipoModal").val(tipo);
		$("#sinopseModal").val(sinopse);
		
		console.log(idFilme);
		$.ajax({
			method : "PUT",
			url : "/filme/update-filme",
			data : {
				"idFilme" : idFilme
			},
			success : function(response) {
				var objFilme = new Object();
				objFilme = JSON.parse(response);
				console.log(objFilme);
			},
			error : function(errResponse) {
				console.log("error",errResponse);
			}
		});
		
		
	});

});

</script>

</body>
</html>