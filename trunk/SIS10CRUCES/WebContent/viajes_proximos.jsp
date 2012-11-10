<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plaza Norte - Gran Terminal Terrestre</title>

<link rel="shortcut icon" type="image/x-icon" href="images/principal/favicon.ico">
<link rel="stylesheet" href="css/style_externo.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<style type="text/css">
@import url("<%=request.getContextPath()%>/css/estilos_principal.css");
</style>
</head>
<body>

<div id="barra_cabecera">
	<div id="barra_cabecera_contenido">
		<span>S&iacute;guenos en:</span>
		<a target="_blank" href="http://www.facebook.com/PlazaNorteOficial"><img align="right" src="images/principal/logo_facebook.png"></a>	
		<a target="_blank" href="https://twitter.com/#!/PlazaNortePeru"><img align="right" src="images/principal/logo_twitter.png"></a>
		<a target="_blank" href="http://www.youtube.com/user/CCplazanorte?ob=5"><img align="right" src="images/principal/logo_youtube.png"></a>
	</div>	
</div>
<div id="cabecera">
	<img align="right" src="images/principal/banner_logo.png">
</div>
<div id="contenido">
<br>
<div id="menu_web">
		<ul class="menu">
			<li><a href="home.jsp">Inicio</a></li>
			<li><a href="ServletBoletaje?tipo=<%=Constantes.ACCION_CONSULTAR_VIAJE %>">Consultar viajes</a></li>
			<li><a href="<%=request.getContextPath() %>/ServletInicial">Ingresar al sistema</a></li>
		</ul>
	</div>
<br>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Consulte su Viaje</font>
   </h3>
	<%
	String mensaje = (String)request.getParameter("mensaje");
	Vector<Viaje> viajes= (Vector<Viaje>)request.getAttribute("viajes");
	%>
	<font style="font-family: verdana; font-size: 0.9em;">
		<%@include file="buscar_viaje_cliente.jsp" %>
	</font>	
	
	<br><hr><br>
	<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
	<%} %>	
	<% if(viajes != null){ %>	
	
	<%@include file="listar_viaje_cliente.jsp" %>
	<%} %>
	<br>
</div>
</div>
<div id="pie">
	<img align="right" src="images/principal/banner_pie.png">
</div>
<div id="barra_pie">
	<div id="barra_pie_izquierda">
		© Copyright 2012 - Plaza Norte
	</div>
	<div id="barra_pie_derecha">
		Panamericana Norte<br>
		Av. Tomás Valle - Av. Túpac Amaru
	</div>
</div>
</body>
</html>