<%@page import="pe.plazanorte.sisterra.entidades.Persona"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@page import="pe.plazanorte.sisterra.entidades.Usuario"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Usuario</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Usuario</font>
   </div>
<%
	Vector<Perfil> perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
	String busqueda=(String)request.getAttribute("busqueda");
	Persona unapersona=(Persona)request.getAttribute("unapersona");
%>
<br>
<%@include file="buscar_usuario_dni.jsp" %>
<form action="ServletSeguridad" name="registrar" method="post">
<table>	
	<tr><td><input type="hidden" name="tipo" value="registrar"><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Usuario:</td>
				<td><input type="text" name="txt_usuario"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Contraseña:</td>
				<td><input type="text" name="txt_pass"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Perfil:</td>
				<td>
					<select name="sel_perfil">
						<% for (int i=0;i<perfiles.size();i++){ %>
							<option value="<%=perfiles.get(i).getId() %>"> <%=perfiles.get(i).getNombre() %> </option>
						<%} %>
					</select>
				</td>			
			</tr>
			<tr>
				<td></td>
				<td>Estado:</td>
				<td>
					<select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>"><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>"><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>
				</td>
			</tr>
			<tr><td><br></td></tr>
</table>
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Detalle Persona</font>
   </div>
<table>			
			<%if(busqueda.equalsIgnoreCase(Constantes.ACCION_BUSQUEDA_REALIZADA)){%>
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre:</td>
				<td>
					<input name="nombre" value="<%=unapersona.getNombre() %>" disabled="disabled"/>
					<input name="txt_dni" value="<%=unapersona.getDni() %>" type="hidden"/>
					<input name="txt_nombre" value="<%=unapersona.getNombre() %>" type="hidden"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Paterno:</td>
				<td>
					<input name="apePat" value="<%=unapersona.getApePat() %>" disabled="disabled"/>
					<input name="txt_apePat" value="<%=unapersona.getApePat() %>" type="hidden"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Materno:</td>
				<td>
					<input name="apeMat" value="<%=unapersona.getApeMat() %>"disabled="disabled"/>
					<input name="txt_apeMat" value="<%=unapersona.getApeMat() %>" type="hidden"/>
				</td>
			</tr>
			<%}else{ %>
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre:</td>
				<td><input name="txt_nombre" disabled="disabled"/></td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Paterno:</td>
				<td><input name="txt_apePat" disabled="disabled" /></td>
			</tr>
			<tr>
				<td></td>
				<td>Apellido Materno:</td>
				<td><input name="txt_apeMat" disabled="disabled"/></td>
			</tr>
			<%} %>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Registrar Usuario" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br><a href="index_seguridad.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>