<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRUEBA</title>
</head>
<body>
<h2>Mantener Usuario</h2>
<%
	String mensaje = (String)request.getParameter("mensaje");
%>

<%@include file="buscar_usuario.jsp" %>
<br>
<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
<%} %>	
	<a href="ServletSeguridad?tipo=agregarUsuario">Agregar</a>
	<br><hr><br>
	<%@include file="listar_usuarios.jsp" %>
<h2><a href="index.jsp">Volver al menu principal</a></h2>

</html>