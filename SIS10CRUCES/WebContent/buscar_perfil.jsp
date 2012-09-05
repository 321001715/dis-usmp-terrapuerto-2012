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
	
	if(document.buscar.codigo.value.length == 0 && document.buscar.nombre.value.length == 0){		
		alert("Debe llenar alguna condición de búsqueda.");
		document.buscar.codigo.focus();				
		return false;
	}else if(isNaN(document.buscar.codigo.value)){		
		alert("Codigo no válido.");
		document.buscar.codigo.focus();	
		return false;
	}	
	return true;
}
</script>
</head>
<body>
<form name="buscar" action="ServletSeguridad" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="filtroPerfil">
	<input type="hidden" name="destino" value="<%=Constantes.MANTENER_PERFIL%>">
	Codigo <input type="text" name="codigo" maxlength="9">
	Nombre <input type="text" name="nombre">
	<input type="submit" value="Buscar">
</form>