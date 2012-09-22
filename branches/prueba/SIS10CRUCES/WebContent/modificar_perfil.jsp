<%@page import="pe.plazanorte.sisterra.entidades.Perfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function validar(){
		if(document.registrar.ruc.value.length == 0){
			alert("Debe llenar el campo cósigo.");
			document.registrar.ruc.focus();
			return false;
		}
		if(document.registrar.razon_social.value.length == 0){
			alert("Debe llenar el campo nombre.");
			document.registrar.razon_social.focus();
			return false;
		}
		return true;
	}	
</script>

</head>
<body>

<%
	Perfil perfil = (Perfil)request.getAttribute("perfil");
	String mensaje = (String)request.getAttribute("mensaje");
%>

<h2>Modificar Perfil</h2>

	
	<br><hr>
	<form action="ServletSeguridad" method="post">
		<input type="hidden" name="tipo" value="modificarPerfil">
		<%if(perfil != null){ %>
		<table cellspacing="10px">
			<tr>
				<td colspan="2"><h3>Datos del Perfil</h3></td>					
			</tr>
			<tr>
				<td>Codigo</td>
				<td><input type="text" name="codigo"  maxlength="11" value="<%=perfil.getId() %>" readonly ></td>				
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" maxlength="11" value="<%=perfil.getNombre() %>" ></td>				
			</tr>		
			<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descripcion" value="<%=perfil.getDescripcion() %>"></td>			
			</tr>
					
			<tr>				
				<td colspan="2"><input value=Modificar type="submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>		
	</form>
	<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
</body>
</html>