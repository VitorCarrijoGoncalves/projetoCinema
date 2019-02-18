<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Listagem de Ingressos</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Ingressos</span>
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
					<!-- table card example -->
					<div  class="pmd-card pmd-z-depth pmd-card-custom-view">
						<div class="table-responsive">
						<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
<!-- 								<th>ID</th> -->
								<th>NOME</th>
								<th>DATA</th>
								<th>VALOR</th>
								<th>FILME</th>
								<th>SALA</th>
							</tr>
						</thead>
						<tbody>
							
				<c:forEach var="ingresso" items="${ingressos}">
						<tr>
							<td></td>
							<input type="hidden" id="idIngresso" name="idIngresso">
<%-- 							<td id="idIngresso">${ingresso.id }</td> --%>
							<td id="nome">${ ingresso.idUsuario.nome }</td>
							<td id="data">${ ingresso.idSecao.dataHora }</td>
							<td id="valorDoIngresso">${ ingresso.idSecao.valorDoIngresso }</td>
							<td id="filme">${ ingresso.idSecao.idFilme.nome }</td>
							<td id="sala">${ ingresso.idSecao.idSala.numero }</td>
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
				<h2 class="pmd-card-title-text">Alterar Ingresso</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Nome</label>
							<input type="hidden" id="idIngressoModal" name="idIngressoModal">
							<select class="select-simple form-control pmd-select2" id="nomeModal" name="nomeModal">
								<option></option>
								<option>aaaa</option>
							</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Seção</label>
						<select class="select-simple form-control pmd-select2" id="secaoModal" name="secaoModal">
							<option></option>
							<option>aaaa</option>
						</select>
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
		var idIngresso = tableRow.find("#idIngresso").text();
		if (confirm("Deseja excluir?")) { 

			console.log(idIngresso);
			$.ajax({
				url : "/ingresso/delete-usuario",
				type : "DELETE",
				data : {
					idIngresso : idIngresso
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
	
		var idIngresso = $(this).closest("tr").find("#idIngresso").text();
		var nome = $(this).closest("tr").find("#nome").text();
		var secao = $(this).closest("tr").find("#secao").text();
		
		$("#idIngressoModal").val(idIngresso);
		$("#nomeModal").val(nome);
		$("#secaoModal").val(login);
		
		console.log(idIngresso);
		$.ajax({
			method : "PUT",
			url : "/ingresso/update-ingresso",
			data : {
				"idIngresso" : idIngresso
			},
			success : function(response) {
				var objIngresso = new Object();
				objIngresso = JSON.parse(response);
				console.log(objIngresso);
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