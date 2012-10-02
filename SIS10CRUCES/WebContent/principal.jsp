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
 	if(perfil.getDescripcion().equals("PROVEEDOR DEL S10C")){
 %>
  		<td style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Proveedor</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_proveedor.jsp" target="_self" class = "menu2">
				<img title="Entrar a Módulo de Proveedor" 
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Ahora puedes tener en un solo sistema el control de toda la información relacionada con 
			los viajes, rutas y servicios que brindas a tus clientes. También podrás consultar en 
			cualquier momento el estado de tus ventas y la situación de tu empresa en el Terrapuerto.
			<br>
			</font>
  		</td>
 <%
 	}
 %>
  		<td style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Ventas</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_ventas.jsp" target="_self" class = "menu2">
				<img title="Entrar a Módulo de Ventas" 
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Este módulo te permitirá realizar tus reservas y compras de los boletos sin necesidad de 
			salir de tu hogar. Te brindará información actualizada de los viajes que realizarán todas 
			las empresas de transporte, sus servicios y precios de manera oportuna.
			<br>
			</font>
  		</td>
  	</tr>
  	<tr>
  		<td colspan="1"></td>
  		<td align="center" style="width: 45%">
  			<font color="white" style="font-family: monospace; font-size: x-large;">
  			<br> <b>Módulo de Seguridad</b> <br><br>
  			</font>
  			<a href="<%=request.getContextPath()%>/index_seguridad.jsp" target="_self" class = "menu2">
				<img title="Entrar a Módulo de Seguridad"
				src="<%=request.getContextPath()%>/images/boton_menu.png">
			</a><br><br>
			<font color="white" style="font-family: 'Trebuchet MS'; font-size: small;">
			Este módulo permite administrar la seguridad del sistema, admninistrar perfiles, usuarios, 
			programas, sesiones y auditoria. Solo para uso de usuarios autorizados para el mantenimiento 
			de la aplicación.
			<br>
			</font>
  		</td>
		<td>
		</td>
  	</tr>
  </table>
</td></tr>
</table>
</div>
</form>
</body>
</html>