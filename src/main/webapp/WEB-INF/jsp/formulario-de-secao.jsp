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

<!--content area start-->
<div id="content" class="pmd-content inner-page">

	<!--tab start-->
	<div class="container-fluid full-width-container">
	
		<h1 class="section-title" id="services">
			<span>Cadastro de Seções</span>
		</h1><!-- End Title -->
			
		<ol class="breadcrumb text-left">
		  <li><a href="/home">Home</a></li>
		  <li class="active">Cadastro</li>
		</ol><!--breadcrum end-->
	
		<div class="section section-custom billinfo"> 
			<form id="validationForm" action="" method="post">
			<div class="pmd-card pmd-z-depth">
				<div class="pmd-card-body">
					<div class="group-fields clearfix row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">
								<label for="regular1" class="control-label">
									Filme
								</label>
								<select class="select-simple form-control pmd-select2">
									<option></option>
								</select>
							</div>
						</div>
					</div>
					<div class="group-fields clearfix row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">       
								<label>Sala</label>
								<input type="text" id="regular1" class="form-control">
								<select class="select-simple form-control pmd-select2">
									<option></option>
								</select>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="form-group pmd-textfield pmd-textfield-floating-label">       
								<label>Início</label>
								<input type="text" id="timepicker" class="form-control" />
							</div>
						</div>
					</div>
				</div>		
				<div class="pmd-card-actions">
					<a href="javascript:void(0);" class="btn btn-primary next">Enviar</a>
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