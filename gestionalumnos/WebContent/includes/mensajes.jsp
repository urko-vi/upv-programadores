<%@ page import="eus.ehu.informatica.gestionalumno.service.mensajes.Mensaje" %>
<%
Mensaje msg = (Mensaje)request.getAttribute("mensaje");


if (msg!=null){
%>
<div class="alert alert-<%=msg.getType() %> alert-dismissable">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <%=msg.getMsg() %>
</div>

<%
}else{
	out.print("msg nulo");
}
%>