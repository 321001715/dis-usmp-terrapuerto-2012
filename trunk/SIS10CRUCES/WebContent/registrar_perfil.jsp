<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validar(){
		if(		document.registrarperfil.nombre.value.length == 0|| 
				document.registrarperfil.descripcion.value.length == 0 ){		
			alert("Debe llenar alguna condición para el registro.");
			document.registrarperfil.nombre.focus();				
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
   	<font style="font-family: monospace; font-size: x-large;">Mantener Perfil</font>
   </h3>
  	
   <div class="ui-corner-bottom ui-widget-content">   
   		<font style="font-family: monospace; font-size: x-large;">Registrar Perfil</font>
   </div>
	<form action="ServletSeguridad" name="registrarperfil" method="post"  onsubmit="return validar()">
		<input type="hidden" name="tipo" value="registrarPerfil">
		<table>	
			<tr><td><br></td></tr>
			<tr>
				<td width="20%"></td>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" maxlength="20"></td>				
			</tr>
			<tr>
				<td></td>
				<td>Descripción:</td>
				<td><input type="text" name="descripcion"></td>			
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="Registrar Perfil" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
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