<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Listagem de Salas</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Salas</span>
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
				<p>Esta é a tabela de visualização de filmes já cadastrados no sistema, aonde
				posso alterar, ou deletar algum registro, caso seja necessário</p>
			</div> <!-- table card title and description end -->
			
			<!-- table card code and example -->
			<div class="col-md-9">
				<div class="component-box">
					<!-- table card example -->
					<div  class="pmd-card pmd-z-depth pmd-card-custom-view">
						<div class="table-responsive">
						<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
<!-- 								<th>Id</th> -->
								<th>Número</th>
								<th>Qtde. de Lugares</th>
								<th>Seções</th>
							</tr>
						</thead>
						<tbody>
							
						<c:forEach var="sala" items="${salas}">
							<tr>
								<td></td>
								<input type="hidden" id="idSala" name="idSala">
<%-- 								<td id="idSala">${sala.id }</td> --%>
								<td id="numero">${ sala.numero }</td>
								<td id="quantidadeDeLugares">${ sala.quantidadeDeLugares }</td>
								<td><a href="#" data-target="#tabela-secoes" data-toggle="modal"><i class="material-icons md-dark pmd-sm">personal_video</i></a></td>
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

<div tabindex="-1" class="modal fade" id="form-dialog" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h2 class="pmd-card-title-text">Alterar Sala</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Número</label>
						<input type="hidden" id="idSalaModal" name="idSalaModal">
						<input type="text" class="mat-input form-control" id="numeroModal" name="numeroModal">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Quantidade de Lugares</label>
						<input type="text" class="mat-input form-control" id="quantidadeDeLugaresModal" name="quantidadeDeLugaresModal">
					</div>
				</form>
			</div>
			<div class="pmd-modal-action">
				<button data-dismiss="modal"  class="btn pmd-ripple-effect btn-primary" type="submit">Salvar Alterações</button>
			</div>
		</div>
	</div>
</div>


<div tabindex="-1" class="modal fade" id="tabela-secoes" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h2 class="pmd-card-title-text">Listagem de Seções</h2>
			</div>
			<div class="modal-body">
			
				<section class="row component-section">
			<div class="col-md-12">
				<div class="component-box">
					<div  class="pmd-card pmd-z-depth pmd-card-custom-view">
						<div class="table-responsive">
						<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>FILME</th>
								<th>DATA</th>
								<th>INGRESSO</th>
							</tr>
						</thead>
						<tbody>
						<tr>
							<td></td>
							<td>aaaa</td>
							<td>aaaaaaaa</td>
							<td>aaaaaa</td>
						</tr>
						
						</tbody>
					</table>
						</div>
					</div> <!-- table card example end -->
				</div>
			</div> 
		</section> 
		
			</div>
		</div>
	</div>
</div>

<jsp:include page="includes/include-footer.jsp"/>
<jsp:include page="includes/include-listagem-scripts.jsp"/>

<script>


$(document).ready(function() {
	
	$("#btn-delete").click(function(e) {
		e.preventDefault();// quando a pessoa clicar em alguns deste bot�es, a tela
		
		var tableRow = $(this).closest("tr");
		var idSala = tableRow.find("#idSala").text();
		if (confirm("Deseja excluir?")) { 

			console.log(idSala);
			$.ajax({
				url : "/sala/delete-sala",
				type : "DELETE",
				data : {
					idSala : idSala
				},
				success : function(data) {
					tableRow.remove();
				},
				error : function(data) {
					
				}
			});

		} else {
			// apenas fechar o modal
		}


	});

});

</script>


<script>

$(document).ready(function() {

	$("#btn-update").click(function(e) {
		e.preventDefault();
	
		var idSala = $(this).closest("tr").find("#idSala").text();
		var numero = $(this).closest("tr").find("#numero").text();
		var quantidadeDeLugares = $(this).closest("tr").find("#quantidadeDeLugares").text();
		
		$("#idSalaModal").val(idSala);
		$("#numeroModal").val(nome);
		$("#quantidadeDeLugaresModal").val(login);
		
		console.log(idSala);
		$.ajax({
			method : "PUT",
			url : "/sala/update-sala",
			data : {
				"idSala" : idSala
			},
			success : function(response) {
				var objSala = new Object();
				objSala = JSON.parse(response);
				console.log(objSala);
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