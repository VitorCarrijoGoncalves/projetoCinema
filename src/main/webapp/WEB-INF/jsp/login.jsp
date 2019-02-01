<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Login | Propeller - Admin Dashboard">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">
<title>Login | Cinema Perto de Você</title>

<jsp:include page="includes/include-login-head.jsp"/>

</head>

<body class="body-custom">
<div class="logincard">
  	<div class="pmd-card card-default pmd-z-depth">
		<div class="login-card">
			<form>	
				<div class="pmd-card-title card-header-border text-center">
					<div class="loginlogo">
						<a href="javascript:void(0);"><img src="themes/images/logo-icon.png" alt="Logo"></a>
					</div>
<!-- 					<h3>Sign In <span>with <strong>PROPELLER</strong></span></h3> -->
				</div>
				
				<div class="pmd-card-body">
					<div class="alert alert-success" role="alert"> Oh snap! Change a few things up and try submitting again. </div>
                    <div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="inputError1" class="control-label pmd-input-group-label">Nome de Usuário</label>
                        <div class="input-group">
<!--                             <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">perm_identity</i></div> -->
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
                    
                    <div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="inputError1" class="control-label pmd-input-group-label">Senha</label>
                        <div class="input-group">
<!--                             <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">lock_outline</i></div> -->
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
                </div>
				<div class="pmd-card-footer card-footer-no-border card-footer-p16 text-center">
					<div class="form-group clearfix">
						<div class="checkbox pull-left">
							<label class="pmd-checkbox checkbox-pmd-ripple-effect">
								<input type="checkbox" checked="" value="">
								<span class="pmd-checkbox"> Lembre-me</span>
							</label>
						</div>
						<span class="pull-right forgot-password">
							<a href="javascript:void(0);">Esqueceu sua senha?</a>
						</span>
					</div>
					<a href="/home" type="button" class="btn pmd-ripple-effect btn-primary btn-block">Login</a>
                    
					<p class="redirection-link">Não tem conta? <a href="javascript:void(0);" class="login-register">Registre-se</a>. </p>
                    
				</div>
				
			</form>
		</div>
		
		<div class="register-card">
			<div class="pmd-card-title card-header-border text-center">
				<div class="loginlogo">
					<a href="javascript:void(0);"><img src="themes/images/logo-icon.png" alt="Logo"></a>
				</div>
<!-- 				<h3>Sign Up <span>with <strong>PROPELLER</strong></span></h3> -->
			</div>
			<form>	
			  <div class="pmd-card-body">
              
              	<div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="nome-de-usuario" class="control-label pmd-input-group-label">Nome de Usuário</label>
                        <div class="input-group">
                            <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">perm_identity</i></div>
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
                    
                    <div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="inputError1" class="control-label pmd-input-group-label">E-mail</label>
                        <div class="input-group">
                            <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">e-mail</i></div>
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
                    
                    <div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="inputError1" class="control-label pmd-input-group-label">Senha</label>
                        <div class="input-group">
                            <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">lock_outline</i></div>
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
              </div>
			  
			  <div class="pmd-card-footer card-footer-no-border card-footer-p16 text-center">
				<a href="index.html" type="button" class="btn pmd-ripple-effect btn-primary btn-block">Registrar</a>
			  	<p class="redirection-link">Já possui conta? <a href="javascript:void(0);" class="register-login">Acessar</a>. </p>
			  </div>
			</form>
		</div>
		
		<div class="forgot-password-card">
			<form>	
			  <div class="pmd-card-title card-header-border text-center">
				<div class="loginlogo">
					<a href="javascript:void(0);"><img src="themes/images/logo-icon.png" alt="Logo"></a>
				</div>
				<h3>Esqueceu sua senha?<br><span>Informe-nos seu e-mail e passaremos um email com sua nova senha</span></h3>
			</div>
			  <div class="pmd-card-body">
					<div class="form-group pmd-textfield pmd-textfield-floating-label">
                        <label for="inputError1" class="control-label pmd-input-group-label">E-mail</label>
                        <div class="input-group">
                            <div class="input-group-addon"><i class="material-icons md-dark pmd-sm">e-mail</i></div>
                            <input type="text" class="form-control" id="exampleInputAmount">
                        </div>
                    </div>
				</div>
			  <div class="pmd-card-footer card-footer-no-border card-footer-p16 text-center">
			  	<a href="index.html" type="button" class="btn pmd-ripple-effect btn-primary btn-block">Enviar</a>
			  	<p class="redirection-link">Ja é registrado? <a href="javascript:void(0);" class="register-login">Acessar</a></p>
			  </div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="includes/include-login-footer.jsp"/>

</body>
</html>