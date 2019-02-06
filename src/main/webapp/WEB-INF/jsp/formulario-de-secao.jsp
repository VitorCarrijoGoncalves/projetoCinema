<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Form Examples | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Cadastro de Seções</title>

<jsp:include page="includes/include-formulario-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<div id="content" class="pmd-content inner-page">

	<!--tab start-->
	<div class="container-fluid full-width-container">
	
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Cadastro de Seções</span>
		</h1>
			
		<ol class="breadcrumb text-left">
		  <li><a href="/home">Home</a></li>
		  <li class="active">Cadastro</li>
		</ol>
		
		<div class="section section-custom billinfo"> 
			<div class="pmd-card pmd-z-depth">
				<div class="pmd-card-body">	
					<form class="form-horizontal" role="form">
						<div class="form-group pmd-textfield">
							<label for="inputEmail3" class="col-sm-2 control-label">Filme</label>
							<div class="col-sm-10">
<!-- 								<input class="form-control input-sm" id="inputEmail3" placeholder="" type="email"> -->
								<select class="select-simple form-control pmd-select2">
									<option></option>
									<option>aaaa</option>
								</select>
							</div>
						</div>
						<div class="form-group pmd-textfield">
							<label for="inputPassword3" class="col-sm-2 control-label">Sala</label>
							<div class="col-sm-10">
								<div class="fg-line">
<!-- 									<input class="form-control input-sm" id="inputPassword3" placeholder="" type="password"> -->
									<select class="select-simple form-control pmd-select2">
										<option></option>
										<option>aaaa</option>
								</select>
								</div>
							</div>
						</div>
						<div class="form-group pmd-textfield">
							<label for="inputPassword3" class="col-sm-2 control-label">Data</label>
							<div class="col-sm-10">
								<div class="fg-line">
									<input type="text" id="datetimepicker-default" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group pmd-textfield">
							<label for="inputPassword3" class="col-sm-2 control-label">Valor do Ingresso</label>
							<div class="col-sm-10">
								<div class="fg-line">
									<input class="form-control input-sm" id="inputEmail3" placeholder="" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-primary pmd-checkbox-ripple-effect">Enviar</button>
							</div>
						</div>
					</form>
				</div>
			</div> 
		</div>
	</div>
</div>

<jsp:include page="includes/include-footer.jsp"/>

<jsp:include page="includes/include-formulario-scripts.jsp"/>
<jsp:include page="includes/include-datepicker-scripts.jsp"/>

</body>
</html>