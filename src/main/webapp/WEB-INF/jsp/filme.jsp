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
								<th>NOME</th>
								<th>GÊNERO</th>
								<th>SINOPSE</th>
								<th>DURAÇÃO</th>
								<th>SEÇÕES</th>
							</tr>
						</thead>
						<tbody>
						
					<c:forEach var="filme" items="${filmes}">
						<tr>
							<td></td>
							<td>${ filme.nome }</td>
							<td>${ filme.genero }</td>
							<td><a href="#" data-target="#bs-dialog" data-toggle="modal"><i class="material-icons md-dark pmd-sm">content_paste</i></a></td>
							<td>${ filme.duracao }</td>
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
						<input type="text" class="mat-input form-control" id="name" value="">
<!-- 						<span class="help-text">Input is required!</span>  -->
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Gênero</label>
						<input type="text" class="mat-input form-control" id="email" value="">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Duração</label>
						<input type="text" class="mat-input form-control" id="mobil" value="">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Tipo</label>
						<input type="text" class="mat-input form-control" id="mobil" value="">
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label class="control-label">Sinopse</label>
						<textarea required class="form-control"></textarea>
					</div>
				</form>
			</div>
			<div class="pmd-modal-action">
				<button data-dismiss="modal"  class="btn pmd-ripple-effect btn-primary" type="button">Salvar Alterações</button>
			</div>
		</div>
	</div>
</div>

<div tabindex="-1" class="modal fade" id="tabela-secoes" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h2 class="pmd-card-title-text">Alterar Filme</h2>
			</div>
			<div class="modal-body">
				<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
					<thead>
						<th></th>
						<th>FILME</th>
						<th>DATA</th>
						<th>INGRESSO</th>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td>aaa</td>
							<td>aaa</td>
							<td>aaa</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<jsp:include page="includes/include-footer.jsp"/>
<jsp:include page="includes/include-listagem-scripts.jsp"/>

</body>
</html>