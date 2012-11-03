<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
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

<script type="text/javascript">

function validar1(){
		if(		document.buscar.dni.value.length == 0||document.buscar.dni.value.length != 8 ){		
			alert("Debe llenar alguna condición para el registro.");
			document.buscar.dni.focus();				
			return false;
		}else {if( !(/^\d{8}$/.test(document.buscar.dni.value)) ) {
		 alert("Solo se permiten numeros.");
 		 return false;
 		
				}}
		
		return true;
	}	
	

</script>



</head>
<body>	
<div class="ui-widget">
   
<form action="ServletSeguridad"  name="buscar"  method="post" onsubmit="return validar1()">
	<input type="hidden" name="tipo" value="buscarDni">
	<table>
			<tr>
				<td>N° de Documento:</td>
				<td><input type="text" name="dni"></td>
				<td><input type="submit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"></td>
			</tr>
					
		</table>
	</form>
</div>
</body>
</html>