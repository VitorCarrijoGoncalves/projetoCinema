<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Listagem de Seções</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Seções</span>
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
								<th>Data</th>
								<th>Valor</th>
								<th>Filme</th>
								<th>Sala</th>
								<th>Ingressos</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="secao" items="${secoes}">
						<tr>
							<td></td>
							<input type="hidden" id="idSecao" name="idSecao">
<%-- 							<td id="idSecao">${secao.id }</td> --%>
							<td id="data">${ secao.dataHora }</td>
							<td id="valorDoIngresso">${ secao.valorDoIngresso }</td>
							<td id="filme">${ secao.idFilme.nome }</td>
							<td id="sala">${ secao.idSala.numero }</td>
							<td><a href="/secao/ingressos"><i class="material-icons md-dark pmd-sm">format_list_bulleted</i></a></td>
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
				<h2 class="pmd-card-title-text">Alterar Seção</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Filme</label>
						<input type="hidden" id="idSecaoModal" name="idSecaoModal">
						<select class="select-simple form-control pmd-select2" id="filmeModal" name="filmeModal">
							<option></option>
							<option>aaaa</option>
						</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Sala</label>
						<select class="select-simple form-control pmd-select2" id="salaModal" name="salaModal">
							<option></option>
							<option>aaaa</option>
						</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Data</label>
						<input type="date" class="form-control" id="dataModal" name="dataModal" />
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Valor do Ingresso</label>
						<input type="text" class="mat-input form-control" id="valorDoIngressoModal" name="valorDoIngressoModal">
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
		e.preventDefault();// quando a pessoa clicar em alguns deste bot�es, a tela
		// n�o sobe para cima 

		// o closest serve para pegar o elemento mais perto de onde eu cliquei na p�g
		// o text pega o texto da tag
		var tableRow = $(this).closest("tr");
		var idSecao = tableRow.find("#idSecao").text();
		if (confirm("Deseja excluir?")) { 

			console.log(idSecao);
			$.ajax({
				url : "/secao/delete-secao",
				type : "DELETE",
				data : {
					idSecao : idSecao
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
	
		var idSecao = $(this).closest("tr").find("#idSecao").text();
		var filme = $(this).closest("tr").find("#filme").text();
		var sala = $(this).closest("tr").find("#sala").text();
		var data = $(this).closest("tr").find("#data").text();
		var valorDoIngresso = $(this).closest("tr").find("#valorDoIngresso").text();
		
		$("#idSecaoModal").val(idSecao);
		$("#filmeModal").val(nome);
		$("#salaModal").val(sala);
		$("#dataModal").val(data);
		$("#valorDoIngressoModal").val(valorDoIngresso);
		
		console.log(idSecao);
		$.ajax({
			method : "PUT",
			url : "/secao/update-secao",
			data : {
				"idSecao" : idSecao
			},
			success : function(response) {
				var objSecao = new Object();
				objSecao = JSON.parse(response);
				console.log(objSecao);
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