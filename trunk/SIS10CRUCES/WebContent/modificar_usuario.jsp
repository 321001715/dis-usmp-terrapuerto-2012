<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	String mensaje = (String)request.getAttribute("mensaje");
	Vector<Perfil> perfiles=new Vector<Perfil>();
	perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
	
%> 
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Usuario</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Modificar Usuario</font>
   </div>
	<form action="ServletSeguridad" method="post">
		<input type="hidden" name="tipo" value="modificar">
		<%if(usuario != null){ %>
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"><input type="hidden" name="id" value="<%=usuario.getId() %>"></td>
				<td>Usuario:</td>
				<td><input name="txt_usuario" value="<%=usuario.getUsuario() %>"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Contraseña:</td>
				<td><input name="txt_pass" value="<%=usuario.getClave() %>"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Nº de Documento:</td>
				<td><input name="txt_dni" value="<%=usuario.getDni()%>"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Perfil:</td>
				<td>
					<select name="idTipoUsuario">
						<% for (int i=0;i<perfiles.size();i++){ %>
							<option value="<%=perfiles.get(i).getId() %>" <%if(usuario.getIdTipUsuario()==perfiles.get(i).getId()){ %>selected="selected" <%} %>> <%=perfiles.get(i).getNombre() %> </option>
						<%} %>
					</select>
				</td>				
			</tr>
			<tr>
				<td></td>
				<td>Estado:</td>
				<td>
					<select name="estado">						
						<option value="ACTIVO" <%if(usuario.getEstado().equals("ACTIVO")){ %>selected="selected" <%} %>>ACTIVO</option>
						<option value="INHABILITADO" <%if(usuario.getEstado().equals("INHABILITADO")){ %>selected="selected" <%} %>>INHABILITADO</option>
					</select>
				</td>				
			</tr>
			<tr><td><br></td></tr>
</table>
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Detalle Persona</font>
   </div>
<table>			
<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre:</td>
				<td><input name="txt_nombre" value="<%=usuario.getNombres() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Paterno:</td>
				<td><input name="txt_apePat" value="<%=usuario.getApePat()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Materno:</td>
				<td><input name="txt_apeMat" value="<%=usuario.getApeMat()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Modificar Usuario" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	
		<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
	</form>
</div>
<br><br><a href="index_seguridad.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>