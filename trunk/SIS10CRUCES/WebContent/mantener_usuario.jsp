<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
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
   	<font style="font-family: monospace; font-size: x-large;">Gestión de Usuarios</font>
   </h3>
	
<%
	String mensaje = (String)request.getParameter("mensaje");
	Vector<Perfil> perfiles=new Vector<Perfil>();
	perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
%>
	
	<form action="ServletSeguridad" method="post" name="buscar" onsubmit="validar()">
		<input type="hidden" name="tipo" value="filtroUsuario">
		<input type="hidden" name="destino" value="<%=Constantes.MANTENER_USUARIO%>">
		<table>
			<tr>
				<td width="20%"></td>
				<td>Usuario: </td>
				<td><input type="text" name="usuario"></td>
				
				<td>Apellido: </td>
				<td><input type="text" name="apellido"></td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td>Perfil: </td>
				<td><select name="perfil">
						<% for (int i=0;i<perfiles.size();i++){ %>
				<option value="<%=perfiles.get(i).getId() %>" > <%=perfiles.get(i).getNombre() %> </option>
				<%} %>
				</select></td>
				
				<td>DNI: </td>
				<td><input type="text" name="dni"></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
	</form>
	<br><a href="ServletSeguridad?tipo=agregarUsuario"">
			<img alt="" src="<%=request.getContextPath()%>/images/adicionar.png">
		</a>
	<br><hr><br>

<% if(mensaje != null){ %>	
		<font color="red"><%= mensaje%></font>
		<br>
<%} %>	
	
	<%@include file="listar_usuarios.jsp" %>
	<br><br><a href="index_seguridad.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</div>
</body>
</html>