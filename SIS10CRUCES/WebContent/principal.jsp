<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="pe.plazanorte.sisterra.entidades.*" %>

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
<% Perfil perfil = (Perfil)session.getAttribute("BPerfil"); %>


<body background="<%=request.getContextPath()%>/images/fondo_principal.png" style="background-position: center top;  background-size: 100% auto;">
<form action="" method="post" name="menPrin">
<div align="center">
<table style="width: 100%;" >
<tr><td>
  <table style="width: 100%;">
  	<tr>
  		<td rowspan="2" style="font-family: sans-serif; font-size: x-large;">
  			<img src="<%=request.getContextPath()%>/images/bienvenido_presentacion.png">
  		</td>
  	</tr>
  	<tr align="center" valign="top">
 <%
 	if(perfil.getNombre().equals("PROVEEDOR") || perfil.getNombre().equals("ADMINISTRADOR")){
 %>
  		<td style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>M�dulo de Proveedor</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_proveedor.jsp" target="_self" class = "menu2">
				<img title="Entrar a M�dulo de Proveedor" 
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Ahora puedes tener en un solo sistema el control de toda la informaci�n relacionada con 
			los viajes, rutas y servicios que brindas a tus clientes. Tambi�n podr�s consultar en 
			cualquier momento el estado de tus ventas y la situaci�n de tu empresa en el Terrapuerto.
			<br>
			</font>
  		</td>
 <%
 	}
 %>
 <%
 	if(perfil.getNombre().equals("CLIENTE") || perfil.getNombre().equals("ADMINISTRADOR")){
 %>
 
  		<td style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>M�dulo de Ventas</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_ventas.jsp" target="_self" class = "menu2">
				<img title="Entrar a M�dulo de Ventas" 
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Este m�dulo te permitir� realizar tus reservas y compras de los boletos sin necesidad de 
			salir de tu hogar. Te brindar� informaci�n actualizada de los viajes que realizar�n todas 
			las empresas de transporte, sus servicios y precios de manera oportuna.
			<br>
			</font>
  		</td>
  	</tr>
<%
 	}
%>
<%
 	if(perfil.getNombre().equals("SOPORTE") || perfil.getNombre().equals("ADMINISTRADOR")){
%>
  	<tr>
  		<td colspan="1"></td>
  		<td align="center" style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>M�dulo de Seguridad</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_seguridad.jsp" target="_self" class = "menu2">
				<img title="Entrar a M�dulo de Seguridad"
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Este m�dulo permite administrar la seguridad del sistema, admninistrar perfiles, usuarios, 
			programas, sesiones y auditoria. Solo para uso de usuarios autorizados para el mantenimiento 
			de la aplicaci�n.
			<br>
			</font>
  		</td>
<%
 	}
%>
<%
 	if(perfil.getNombre().equals("ANFITRION") || perfil.getNombre().equals("ADMINISTRADOR")){
%>
  		<td align="center" style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>M�dulo de Embarque</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_embarque.jsp" target="_self" class = "menu2">
				<img title="Entrar a M�dulo de Seguridad"
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Este m�dulo permite controlar el embarque de pasajeros a los veh�culos, imprimir reportes y
			boletos necesarios para el anfitri�n. Ayudar� a controlar, verificar y reportar la informaci�n 
			generada por los otros m�dulos de la aplicaci�n en el momento oportuno.
			<br>
			</font>
  		</td>
  	</tr>
<%
 	}
%>
  </table>
</td></tr>
</table>
</div>
</form>
</body>
</html>