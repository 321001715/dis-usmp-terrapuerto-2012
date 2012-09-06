<%@page import="pe.plazanorte.sisterra.entidades.Clasificacion"%>
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
			alert("Debe llenar el campo RUC.");
			document.registrar.ruc.focus();
			return false;
		}
		if(document.registrar.razon_social.value.length == 0){
			alert("Debe llenar el campo Razón social.");
			document.registrar.razon_social.focus();
			return false;
		}
		if(document.registrar.razon_comercial.value.length == 0){
			alert("Debe llenar el campo Razón comercial.");
			document.registrar.razon_comercial.focus();
			return false;
		}
		if(document.registrar.direccion.value.length == 0){
			alert("Debe llenar el campo Dirección.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.telefono.value.length == 0){
			alert("Debe llenar el campo Teléfono.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.usuario.value.length == 0){
			alert("Debe llenar el campo usuario.");
			document.registrar.usuario.focus();
			return false;
		}
		if(document.registrar.clave.value.length == 0){
			alert("Debe escribir una clave.");
			document.registrar.clave.focus();
			return false;
		}
		if(document.registrar.clave.value.length < 5){
			alert("Su clave debe tener más de 5 dígitos.");
			document.registrar.clave.focus();
			return false;
		}
		return true;
	}	
</script>

</head>
<body>

<%
	Clasificacion clasificacion = (Clasificacion)request.getAttribute("clasificacion");
	String mensaje = (String)request.getAttribute("mensaje");
%>

<h2>Modificar clasificacion</h2>

	<%@include file="buscar_clasificacion.jsp" %>
	<br><hr>
	<form action="ServletClasificacion" method="post">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_CLASIFICACION%>">
		<%if(clasificacion != null){ %>
		<table cellspacing="10px">
			<tr>
				<td colspan="2"><h3>Datos de Clasificacion</h3></td>					
			</tr>
			<tr>
				<td>C&oacute;digo</td>
				<td><input type="text" name="id" maxlength="11" value="<%=clasificacion.getId() %>" readonly="readonly"></td>				
			</tr>
			<tr>
				<td>Descripción</td>
				<td><input type="text" name="descripcion" maxlength="11" value="<%=clasificacion.getDescripcion() %>" ></td>				
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