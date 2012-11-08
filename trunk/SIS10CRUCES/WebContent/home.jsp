<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plaza Norte - Gran Terminal Terrestre</title>
<link rel="shortcut icon" type="image/x-icon" href="images/principal/favicon.ico">
<style type="text/css">
@import url("css/estilos_principal.css");
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

	<div id="menu_web">
		<ul class="menu">
			<li><a href="home.jsp">Inicio</a></li>
			<li><a href="ServletBoletaje?tipo=<%=Constantes.ACCION_CONSULTAR_VIAJE %>">Consultar viajes</a></li>
			<li><a href="<%=request.getContextPath() %>/ServletInicial">Ingresar al sistema</a></li>
		</ul>
	</div>	
	
	<div id="contenido">
	<h3>La empresa</h3>
		<p>El nuevo y moderno Gran Terminal Terrestre Plaza Norte se ha convertido en un pilar de cambio en servicios de transporte terrestre interprovincial e internacional que merece nuestro país, no solo por su diseño e innovación en cada una de sus instalaciones, sino por el sinnúmero de beneficios, debido a que es el primer terminal que coexiste con el centro comercial más grande del país: C.C. Plaza Norte.</p>
		<p style="text-align: center;"><img alt="imgPrincipal.jpg" src="<%=request.getContextPath() %>/images/imgPrincipal.jpg"></p>
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