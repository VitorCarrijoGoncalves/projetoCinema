<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Form Examples | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Cadastro de Filmes</title>

<jsp:include page="includes/include-formulario-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<!--content area start-->
<div id="content" class="pmd-content inner-page">

	<div class="container-fluid full-width-container">
	
		<h1 class="section-title" id="services">
			<span>Cadastro de Filmes</span>
		</h1><!-- End Title -->
			
		<!--breadcrum start-->
		<ol class="breadcrumb text-left">
		  <li><a href="/home">Home</a></li>
		  <li class="active">Cadastro</li>
		</ol><!--breadcrum end-->
	
		<div class="section section-custom billinfo"> 
			<form id="validationForm" action="/formulario-de-filme" method="post">
			<div class="pmd-card pmd-z-depth">
				<div class="pmd-card-body">
				 <div class="alert alert-success" id="mensagem-sucesso">
	    				Filme cadastrado com sucesso!
	  				</div>
	  				  <div class="alert alert-danger" id="mensagem-erro">
    					 Filme não cadastrado!
  					</div>
					<div class="group-fields clearfix row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">
								<label for="regular1" class="control-label">
									Nome
								</label>
								<input type="text" id="nome" name="nome" class="form-control">
							</div>
						</div>
					</div>
					<div class="group-fields clearfix row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">       
								<label>Gênero</label>
								<input type="text" id="genero" name="genero" class="form-control">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">       
								<label>Duração</label>
								<input type="text" id="duracao" name="duracao" class="form-control">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">
								<label for="regular1" class="control-label">
									Status
								</label>
								<select class="select-simple form-control pmd-select2" id="idUsuario" name="idUsuario">
									<option value="NULL"></option>
									<option value="TRUE">Filme em Lançamento</option>
									<option value="FALSE">Filme fora de Lançamento</option>
								</select>
							</div>
						</div>
					</div>
					<div class="group-fields clearfix row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">
							  <label class="control-label">Sinopse</label>
							  <textarea required class="form-control" id="sinopse" name="sinopse"></textarea>
							</div>
						</div>
					</div>
				</div>		
				<div class="pmd-card-actions">
					<button type="submit" class="btn btn-primary next">Enviar</button>
				</div>
			</div> 
			</form>
		</div>
	</div>
</div>

<jsp:include page="includes/include-footer.jsp"/>

<jsp:include page="includes/include-formulario-scripts.jsp"/>
<jsp:include page="includes/include-datepicker-scripts.jsp"/>

</body>
</html>