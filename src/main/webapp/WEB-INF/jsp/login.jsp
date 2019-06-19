<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Login | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">
<title>Login | Cinema Propeller</title>

<!-- reCAPTCHA Libary -->
<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

<jsp:include page="includes/include-login-head.jsp" />

</head>

<body class="body-custom">
	<div class="logincard">
		<div class="pmd-card card-default pmd-z-depth">
			<div class="login-card">
				<form action="/login" method="post">
					<div class="pmd-card-title card-header-border text-center">
						<div class="loginlogo">
							<img src="themes/images/logo-icon.png" alt="Logo">
						</div>
						<h3>
							<span><strong>Cinema Propeller</strong></span>
							<input type="hidden" value="${erro}" id="mensagem-erro">
						</h3>
					</div>

					<div class="pmd-card-body">
						<div class="form-group pmd-textfield pmd-textfield-floating-label">
							<label for="inputError1" class="control-label pmd-input-group-label">E-mail</label>
							<div class="input-group">
								<div class="input-group-addon">
									<i class="material-icons md-dark pmd-sm">perm_identity</i>
								</div>
								<input type="text" class="form-control" name="email" required="required">
							</div>
						</div>

						<div class="form-group pmd-textfield pmd-textfield-floating-label">
							<label for="inputError1" class="control-label pmd-input-group-label">Senha</label>
							<div class="input-group">
								<div class="input-group-addon">
									<i class="material-icons md-dark pmd-sm">lock_outline</i>
								</div>
								<input type="password" class="form-control" name="senha" required="required">
							</div>
						</div>
					</div>
					<!-- reCAPTCHA -->
					<div class="g-recaptcha"
						data-sitekey="6Lc7wKIUAAAAAFD2w2RE4foYzgONizD3c6Y4lp3z"></div>

					<!-- <input type="submit" value="Submit" /> -->
					<!--reCAPTCHA -->
					<div class="pmd-card-footer card-footer-no-border card-footer-p16 text-center">

						<div class="form-group clearfix">
<!-- 							<div class="checkbox pull-left"> -->
<!-- 								<label class="pmd-checkbox checkbox-pmd-ripple-effect"> -->
<!-- 									<input type="checkbox" value="">  -->
<!-- 									<span class="pmd-checkbox"> Lembre-me</span> -->
<!-- 								</label> -->
<!-- 							</div> -->
						</div>
						
<!-- 						<button type="submit" class="btn pmd-ripple-effect btn-primary btn-block">Login</button> -->
						<input type="submit" class="btn pmd-ripple-effect btn-primary btn-block">
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="includes/include-login-scripts.jsp" />
	
	
	<script>
	
	if ($("#mensagem-erro").val() != "") {
		alert("Cadastro inexistente");
	}
	
	</script>
	
	

</body>
</html>