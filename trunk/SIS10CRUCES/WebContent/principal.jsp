<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="pe.plazanorte.sisterra.entidades.*" %>

<script language="JavaScript">

  </script>
 
<html>
<head>
<SCRIPT> 
if (history.forward(1))
    {
    location.replace(history.forward(1));
    }
</SCRIPT>

<title>Menu Principal &sect;&cent; </title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<STYLE TYPE = "text/css">
	a.menu2:link{color: white;text-decoration: none}
	a.menu2:visited{color: #FFE3B5;text-decoration: none}
	a.menu2:active{color: #CE9A63;text-decoration: none}
	a.menu2:hover{color: #FFE3B5;text-decoration: none;font-weight: bold }
</STYLE>
</head>

<% Usuario uu = (Usuario)session.getAttribute("BUsuario"); %>
<%--body bgcolor="#630000" modificado por la sgte linea 2011/08/29--%>
<body bgcolor="#FFCC00"> 
<form action="" method="post" name="menPrin" onsubmit="redirect()">
<div align="center">
<table style="width: 100%; height: 100%">
<tr><td>
  <table border="1" style="width: 100%; height: 100%">
  	<tr>
  		<td colspan="3" style="font-family: monospace; font-size: x-large;">
  			Bienvenido al nuevo portal que les ofrece el Terminal Terrestre Plaza Norte.
  		</td>
  	</tr>
  	<tr align="center" valign="top">
  		<td style="width: 30%">
  			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Proveedor</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index.jsp" target="_self" class = "menu2">
				<img alt="Entrar a Módulo de Proveedor" 
				src="<%=request.getContextPath()%>/images/boton_menu.jpg">
			</a><br><br>
			<font style="font-family: fantasy; font-size: x-small; text-align: justify;">
			Ahora puedes tener en un solo sistema el control de toda la información relacionada con 
			los viajes, rutas y servicios que brindas a tus clientes. También podrás consultar en 
			cualquier momento el estado de tus ventas y la situación de tu empresa en el Terrapuerto.
			</font>
  		</td>
  		<td style="width: 30%">
  			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Ventas</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/login.jsp" target="_self" class = "menu2">
				<img alt="Entrar a Módulo de Ventas" 
				src="<%=request.getContextPath()%>/images/boton_menu.jpg">
			</a><br><br>
			<font style="font-family: fantasy; font-size: x-small; text-align: justify;">
			Este módulo te permitirá realizar tus reservas y compras de los boletos sin necesidad de 
			salir de tu hogar. Te brindará información actualizada de los viajes que realizarán todas 
			las empresas de transporte, sus servicios y precios de manera oportuna.
			</font>
  		</td>
  		<td style="width: 30%">
  			<font style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Seguridad</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/login.jsp" target="_self" class = "menu2">
				<img alt="Entrar a Módulo de Seguridad" 
				src="<%=request.getContextPath()%>/images/boton_menu.jpg">
			</a><br><br>
			<font style="font-family: fantasy; font-size: x-small; text-align: justify;">
			Este modulo permite administrar la seguridad del sistema, admninistrar perfiles, usuarios, 
			programas, sesiones y auditoria. Solo para uso de usuarios autorizados para el mantenimiento 
			de la aplicación.
			</font>
  		</td>
  	</tr>
  </table>
</td></tr>
</table>
</div>
</form>
</body>
</html>