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
		if(document.registrar.nombre.value.length == 0){
			alert("Debe llenar el campo nombre.");
			document.registrar.nombre.focus();
			return false;
		}
		if(document.registrar.descripcion.value.length == 0){
			alert("Debe llenar el campo descripcion.");
			document.registrar.descripcion.focus();
			return false;
		}
		alert("Registro Exitoso.");
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
<div class="ui-widget">
   <h3 class="ui-corner-top ui-widget-header"> 
   	<font style="font-family: monospace; font-size: x-large;">Mantener Clasificación</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Clasificación</font>
   </div>
	<form action="ServletClasificacion" method="post" name="registrar" onsubmit="return validar()">
		<input type="hidden" name="tipo" value="<%=Constantes.ACCION_REGISTRAR_CLASIFICACION%>">
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Código Clasificación:</td>
				<td><input type="text" name="idTipoServicio" maxlength="11" readonly="readonly"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"></td>			
			</tr>
			<tr>
				<td></td>
				<td>Descripción:</td>
				<td><input type="text" name="descripcion"></td>			
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Registrar Clasificación" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
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