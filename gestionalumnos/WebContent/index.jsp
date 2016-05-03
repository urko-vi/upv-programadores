<%@ include file="includes/header.jsp" %>

<body>
<div class="container-fluid">
	<main class="row">
		<section class="col-xs-12">
			<a href="listadoAlumnos.do" class="btn btn-default">
				Ver los alumnos</a>
			<a href="listadoAsignaturas.do" class="btn btn-default">
				Ver las asignaturas</a>
			<div class="row">
			<jsp:include page="includes/mensajes.jsp" />
			 
			</div>
		</section>
	</main>
</div>
</body>
</html>