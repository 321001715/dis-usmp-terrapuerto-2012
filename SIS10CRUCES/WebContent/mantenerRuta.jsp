<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar Ruta</title>
</head>
<body>
<h2>Mantener Ruta</h2>
<%
	String mensaje = (String)request.getParameter("mensaje");
%>
<%@include file="buscar_ruta.jsp" %>
<br>
<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
<%} %>	
	<a href="registrarRuta.jsp">Registrar Ruta</a>
	<br><hr><br>
	<%@include file="listar_ruta.jsp" %>
<br>
<a href="index_proveedor.jsp">Volver al Men&uacute; principal</a>
</html>