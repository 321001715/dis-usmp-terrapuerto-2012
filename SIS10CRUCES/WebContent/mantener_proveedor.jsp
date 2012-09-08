<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar proveedor</title>
</head>
<body>
<h2>Mantener proveedor</h2>
<%
	String mensaje = (String)request.getParameter("mensaje");
%>
<%@include file="buscar_proveedor.jsp" %>
<br>
<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
<%} %>	
	<a href="registrar_proveedor.jsp">Registrar Proveedor</a>
	<br><hr><br>
	<%@include file="listar_proveedores.jsp" %>
<br>
<a href="index.jsp">Volver al Men&uacute; principal</a>
</html>