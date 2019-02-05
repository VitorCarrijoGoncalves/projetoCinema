<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Form Examples | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Cadastro de Salas</title>

<jsp:include page="includes/include-formulario-head.jsp"/>

<body>

<jsp:include page="includes/include-sidebar.jsp"/>

<div id="content" class="pmd-content inner-page">

	<!--tab start-->
	<div class="container-fluid full-width-container">
	
		<!-- Title -->
		<h1 class="section-title" id="services">
			<span>Cadastro de Salas</span>
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
							<label for="inputEmail3" class="col-sm-2 control-label">Número</label>
							<div class="col-sm-10">
								<input class="form-control input-sm" id="inputEmail3" placeholder="Email" type="email">
							</div>
						</div>
						<div class="form-group pmd-textfield">
							<label for="inputPassword3" class="col-sm-2 control-label">Quantidade de Lugares</label>
							<div class="col-sm-10">

								<div class="fg-line">
									<input class="form-control input-sm" id="inputPassword3" placeholder="Password" type="password">
								</div>
							</div>
						</div>
<!-- 						<div class="form-group"> -->
<!-- 							<div class="col-sm-offset-2 col-sm-10"> -->
<!-- 								<div class="checkbox"> -->
<!-- 									<label class="pmd-checkbox pmd-checkbox-ripple-effect"> -->
<!-- 										<input value="" type="checkbox"> -->
<!-- 										<i class="input-helper"></i> -->
<!-- 										Remember me -->
<!-- 									</label> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
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

</body>
</html>