<%@page import="pe.plazanorte.sisterra.entidades.Clasificacion"%>
<%@page import="pe.plazanorte.sisterra.util.Constantes"%>

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
			alert("Debe llenar el campo Raz�n social.");
			document.registrar.razon_social.focus();
			return false;
		}
		if(document.registrar.razon_comercial.value.length == 0){
			alert("Debe llenar el campo Raz�n comercial.");
			document.registrar.razon_comercial.focus();
			return false;
		}
		if(document.registrar.direccion.value.length == 0){
			alert("Debe llenar el campo Direcci�n.");
			document.registrar.telefono.focus();
			return false;
		}
		if(document.registrar.telefono.value.length == 0){
			alert("Debe llenar el campo Tel�fono.");
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
			alert("Su clave debe tener m�s de 5 d�gitos.");
			document.registrar.clave.focus();
			return false;
		}
		return true;
	}	
</script>
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
	Clasificacion clasificacion = (Clasificacion)request.getAttribute("clasificacion");
	String mensaje = (String)request.getAttribute("mensaje");
%>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Clasificaci�n</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Modificar Clasificaci�n</font>
   </div>
	<form action="ServletClasificacion" method="post">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_CLASIFICACION%>">
		<%if(clasificacion != null){ %>
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>C�digo Clasificaci�n:</td>
				<td><input type="text" name="id" maxlength="11" value="<%=clasificacion.getId() %>" readonly="readonly"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" maxlength="11" value="<%=clasificacion.getNombre() %>" ></td>				
			</tr>
			<tr>
				<td></td>
				<td>Descripci�n:</td>
				<td><input type="text" name="descripcion" maxlength="11" value="<%=clasificacion.getDescripcion() %>" ></td>				
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Modificar Clasificaci�n" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	</form>
	<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
</div>
<br><br><a href="index_seguridad.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atr�s...
	&nbsp;
</body>
</html>