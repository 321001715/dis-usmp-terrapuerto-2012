<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Consulte su Viaje</font>
   </h3>
	<%
	String mensaje = (String)request.getParameter("mensaje");
	Vector<Viaje> viajes= (Vector<Viaje>)request.getAttribute("viajes");
	%>
	<%@include file="buscar_viaje_cliente.jsp" %>
	
	<br><hr><br>
	<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
	<%} %>	
	<% if(viajes != null){ %>	
	
	<%@include file="listar_viaje_cliente.jsp" %>
	<%} %>
	<br><br><a href="index_ventas.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atr�s X...
	&nbsp;
</div>
</body>
</html>