<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post" class="needs-validation" novalidate>
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input class="form-control" type="email" name="email"
				placeholder="Email" value="${usuario.email}" required>
			<div class="invalid-feedback">Introduce un email válido</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input class="form-control" type="password" name="password"
				placeholder="Contraseña" required>
			<div class="invalid-feedback">Introduce una contraseña</div>
		</div>
	</div>

	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Iniciar sesión</button>
			<div class="text-danger">${error}</div>
		</div>
	</div>
</form>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>