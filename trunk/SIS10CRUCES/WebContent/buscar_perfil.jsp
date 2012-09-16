<%@page import="pe.plazanorte.sisterra.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validar(){
	if(document.buscar.codigo.value.length == 0 && document.buscar.nombre.value.length == 0){		
		alert("Debe llenar alguna condici�n de b�squeda.");
		document.buscar.codigo.focus();				
		return false;
	}else if(isNaN(document.buscar.codigo.value)){		
		alert("Codigo no v�lido.");
		document.buscar.codigo.focus();	
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
   <div class="ui-corner-bottom ui-widget-content">   
   <font style="font-family: monospace; font-size: x-large;">Filtros de B�squeda</font>
   </div>
&nbsp;   
<form name="buscarPerfil" action="ServletSeguridad" method="post" onsubmit="validar()">
	<input type="hidden" name="tipo" value="filtroPerfil">
	<input type="hidden" name="destino" value="<%=Constantes.MANTENER_PERFIL%>">
	<table>
			<tr>
				<td width="20%"></td>
				<td>C�digo: </td>
				<td><input type="text" name="codigo"></td>
				
				<td>Descripci�n: </td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="submit" value="Buscar" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
				</td>
			</tr>			
		</table>
	</form>
</div>
</body>
</html>