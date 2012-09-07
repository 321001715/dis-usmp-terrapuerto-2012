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
<title>Insert title here</title>
</head>
<body>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	String mensaje = (String)request.getAttribute("mensaje");
	Vector<Perfil> perfiles=new Vector<Perfil>();
	perfiles = (Vector<Perfil>)request.getAttribute("perfiles");
	
%> 

<h2>Modificar Usuario</h2>

	
	<br><hr><br>
	<form action="ServletSeguridad" method="post">
		<input type="hidden" name="tipo" value="modificar">
		<%if(usuario != null){ %>
		      	
		<table>
			<tr>
				
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Usuario:</td>
				<td><input name="txt_usuario" value="<%=usuario.getUsuario() %>"></td>
				<td>Pass:</td>
				<td><input name="txt_pass" value="<%=usuario.getClave() %>"></td>
			</tr>
			<tr>
				<td>Numero de Documento</td>
				<td><input name="txt_dni" value="<%=usuario.getDni()%>"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Perfil</td>
				<td><select name="idTipoUsuario">
						<% for (int i=0;i<perfiles.size();i++){ %>
				<option value="<%=perfiles.get(i).getId() %>" <%if(usuario.getIdTipUsuario()==perfiles.get(i).getId()){ %>selected="selected" <%} %>> <%=perfiles.get(i).getNombre() %> </option>
				<%} %>
				</select></td>
				<td>Estado</td>
				<td><select name="estado">						
						<option value="<%=Constantes.ESTADO_ACTIVO%>" <%if(usuario.getEstado().equals(Constantes.ESTADO_ACTIVO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_ACTIVO%></option>
						<option value="<%=Constantes.ESTADO_INHABILITADO%>" <%if(usuario.getEstado().equals(Constantes.ESTADO_INHABILITADO)){ %>selected="selected" <%} %>><%=Constantes.ESTADO_INHABILITADO%></option>
					</select>	
				</td>
			</tr>
			<tr>
				<td><b><u>Detalle de Persona</u></b></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input name="txt_nombre" value="<%=usuario.getNombres() %>"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Paterno</td>
				<td><input name="txt_apePat" value="<%=usuario.getApePat()%>"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Apellido Materno</td>
				<td><input name="txt_apeMat" value="<%=usuario.getApeMat()%>"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input value="Modificar" type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	
		<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
	</form>
</body>
</html>