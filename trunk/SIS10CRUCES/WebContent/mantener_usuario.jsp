<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRUEBA</title>
</head>
<body>
<h2>Mantener proveedor</h2>
<%
	String mensaje = (String)request.getParameter("mensaje");
%>

<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br><br>
<%} %>
<a href="registrar_proveedor.jsp">Registrar Usuario</a><br>
<a href="eliminar_proveedor.jsp">Eliminar Usuarior</a><br>
<a href="modificar_proveedor.jsp">Consultar Usuario</a><br>
<a href="ServletProveedor?tipo=listar">Listar Usuario</a><br><br><br>
 
<%@include file="listar_usuarios.jsp" %>

</html>