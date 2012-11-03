<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validar(){
	if( document.buscar.dni.value.lengt =! '8' ){		
		alert("Complete los datos de busqueda para el DNI");
		document.buscar.dni.focus();				
		return false;
		}else if( isNaN(document.buscar.dni.value) ){		
		alert("DNI no válido.");
		document.buscar.dni.focus();	
		return false;
	}	
		
		
		
	return true;
}

</script>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="css/humanity.datepick.css" type="text/css"/>
<link rel="stylesheet" href="css/jquery.datepick.css" type="text/css"/> 
<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.7.3.custom.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>	
<div class="ui-widget">
   
<form name="buscar" action="ServletSeguridad" method="post" onsubmit="return validar()">
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