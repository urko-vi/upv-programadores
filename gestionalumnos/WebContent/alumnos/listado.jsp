<%@page import="java.util.List"%>
<%@page import="eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional"%>
<%@ include file="../includes/header.jsp" %>
<body>
<div class="container-fluid">
	<main class="row">
		<section class="col-xs-12">
			<a href="javascript:history.go(-1);" class="btn btn-default">
				Atras</a>
			<a href="listadoAlumnos.do" class="btn btn-default">
				Crear Alumno</a>
			<div class="row">
			<jsp:include page="../includes/mensajes.jsp" />
			 <%
			 List<AlumnoNacional> alumnos= null;
			 alumnos = (List<AlumnoNacional>)request.getAttribute("alumnos");
			 if(alumnos!=null){
				 for(AlumnoNacional alumno: alumnos){
					out.println("<p class='col-xs-12'><a href='actualizarAlumno.do?id='"+alumno.getCodigo()+"'>"+alumno.toHTML()+"</a></p>");
				 }
				
			 }
			 
			 %>
			 
			</div>
		</section>
	</main>
</div>
</body>
</html>