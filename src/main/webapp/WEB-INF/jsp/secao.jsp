<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Data Table | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Listagem de Se��es</title>

<jsp:include page="includes/include-listagem-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

<!--tab start-->
<div class="container-fluid full-width-container data-tables">
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Se��es</span>
		</h1><!-- End Title -->
	
		<!--breadcrum start-->
		<ol class="breadcrumb text-left">
		  <li><a href="/home">Home</a></li>
		  <li class="active">Visualiza��o</li>
		</ol><!--breadcrum end-->
	
		<!-- table card -->
		<section class="row component-section">
		
			<!-- table card title and description -->
			<div class="col-md-3">
				<div id="card">
					<h2>Descri��o</h2>
				</div>
				<p>Esta � a tabela de visualiza��o de filmes j� cadastrados no sistema, aonde
				posso alterar, ou deletar algum registro, caso seja necess�rio</p>
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
								<th>Data</th>
								<th>Valor</th>
								<th>Filme</th>
								<th>Sala</th>
<!-- 								<th>T�rmino</th> -->
								<th>Ingressos</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="secao" items="${secoes}">
						<tr>
							<td></td>
							<td>${ secao.dataHora }</td>
							<td>${ secao.valorDoIngresso }</td>
							<td>${ secao.idFilme.nome }</td>
							<td>${ secao.idSala.numero }</td>
<!-- 							<td>23:45</td> -->
							<td><a href="#" data-target="#tabela-usuarios" data-toggle="modal"><i class="material-icons md-dark pmd-sm">format_list_bulleted</i></a></td>
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
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">�</button>
				<h2 class="pmd-card-title-text">Alterar Se��o</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Filme</label>
						<select class="select-simple form-control pmd-select2">
							<option></option>
							<option>aaaa</option>
						</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Sala</label>
						<select class="select-simple form-control pmd-select2">
							<option></option>
							<option>aaaa</option>
						</select>
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Data</label>
						<input type="date" id="mobil" class="form-control" />
					</div>
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
						<label for="first-name">Valor do Ingresso</label>
						<input type="text" class="mat-input form-control" id="mobil" value="">
					</div>
				</form>
			</div>
			<div class="pmd-modal-action">
				<button data-dismiss="modal"  class="btn pmd-ripple-effect btn-primary" type="button">Salvar Altera��es</button>
			</div>
		</div>
	</div>
</div>


<div tabindex="-1" class="modal fade" id="tabela-usuarios" style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bordered">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">�</button>
				<h2 class="pmd-card-title-text">Alterar Sala</h2>
			</div>
			<div class="modal-body">
				<table id="example-checkbox" class="table pmd-table table-hover table-striped display responsive nowrap" cellspacing="0" width="100%">
					<thead>
						<th></th>
						<th>NOME</th>
					</thead>
					<tbody>
						<tr>
							<td></td>
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