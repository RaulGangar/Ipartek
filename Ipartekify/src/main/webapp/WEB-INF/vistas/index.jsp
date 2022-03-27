<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row h-100 bg-dark text-light">
	<div id="lateral-izquierdo"
		class="h-100 col-2 d-flex flex-column align-items-stretch pt-3 ${cancion != null ? 'espacio-reproductor': ''}">
		<nav id="menu" class="flex-shrink-1 pb-3 border-bottom">
			<ul class="nav flex-column">
				<c:forEach items="${artistas}" var="a">
					<li class="nav-item"><a class="nav-link link-light"
						href="index?artista=${a.id}">${a.nombre}</a></li>
				</c:forEach>
			</ul>
		</nav>
		<%@ include file="/WEB-INF/vistas/includes/listas.jsp"%>
		<div id="caratula" class="flex-shrink-1">
			<div class="card bg-dark text-white">
				<img src="${album.foto}" class="card-img" alt="">
				<div class="card-img-overlay">
					<h5 class="card-title">${cancion.nombre}</h5>
					<p class="card-text">${cancion.tiempo}</p>
				</div>
			</div>
		</div>
	</div>
	<div id="central" class="h-100 col pt-3">
		<c:if test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				${error}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>
		<c:if test="${exception != null}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				${exception.message}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>
		<c:if test="${artista != null}">
			<%@ include file="/WEB-INF/vistas/includes/artista.jsp"%>
		</c:if>
		<c:if test="${album != null}">
			<%@ include file="/WEB-INF/vistas/includes/album.jsp"%>
		</c:if>
	</div>
	<div id="reproductor" class="col-12 fixed-bottom">
		<c:if test="${cancion.mp3 != null}">
			<iframe class="w-100"
				src="https://www.youtube-nocookie.com/embed/${cancion.mp3}"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
		</c:if>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>