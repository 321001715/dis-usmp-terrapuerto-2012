<%@page import="pe.plazanorte.sisterra.entidades.Ruta"%>
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
	Ruta ruta = (Ruta)request.getAttribute("ruta");
	String mensaje = (String)request.getAttribute("mensaje");
%>
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Ruta</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Modificar Ruta</font>
   </div>
	<form action="ServletProveedor" method="post">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_MODIFICAR_RUTA%>">
		<%if(ruta != null){ %>
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Código Ruta:</td>
				<td><input type="text" name="codRuta" value="<%=ruta.getId()%>" readonly="readonly"></td>				
			</tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre de Ruta:</td>
				<td><input type="text" name="nomRuta" value="<%=ruta.getNomRuta()%>"></td>				
			</tr>
			
			
			<tr>
				<td></td>
				<td>Origen:</td>
				<td><input type="text" name="origen" value="<%=ruta.getOrigen()%>"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Destino:</td>
				<td><input type="text" name="destino" value="<%=ruta.getDestino()%>"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Km.:</td>
				<td><input type="text" name="km" value="<%=ruta.getKm()%>"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Duración:</td>
				<td><input type="text" name="duracion" value="<%=ruta.getDuracion()%>"> hrs.</td>			
			</tr>
			<tr>
				<td></td>
				<td>Estado:</td>
				<td>
					<select name="estado">						
						<option value="ACTIVO" <%if(ruta.getEstado().equals("ACTIVO")){ %>selected="selected" <%} %>>ACTIVO</option>
						<option value="INHABILITADO" <%if(ruta.getEstado().equals("INHABILITADO")){ %>selected="selected" <%} %>>INHABILITADO</option>
					</select>
				</td>				
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Modificar Ruta" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>
		</table>
	
		<%}else if(mensaje != null){ %>
			<font color="red"><%=mensaje %></font>
		<%} %>
	</form>
</div>
<br><br><a href="index_ventas.jsp">
			<img alt="" src="<%=request.getContextPath()%>/images/atras.jpg"> 
		</a> Atrás...
	&nbsp;
</body>
</html>