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
	
	if(document.buscar.ruc.value.length == 0 && document.buscar.razSocial.value.length == 0){		
		alert("Debe llenar alguna condici�n de b�squeda.");
		document.buscar.ruc.focus();				
		return false;
	}else if(isNaN(document.buscar.ruc.value)){		
		alert("N�mero de RUC no v�lido.");
		document.buscar.ruc.focus();	
		return false;
	}	
	return true;
}
</script>
</head>
<body>
<form name="buscar" action="ServletClasificacion" method="post" >
	<input type="hidden" name="tipo" value="<%=Constantes.ACCION_FILTRO_CLASIFICACION%>">
	<input type="hidden" name="destino" value="<%=Constantes.MANTENER_CLASIFICACION%>">
	Codigo<input type="text" name="idTipoServicio" maxlength="9" readonly="readonly">
	Descripci�n<input type="text" name="descripcion">
	<input type="submit" value="Buscar">
</form>

</body>
</html>