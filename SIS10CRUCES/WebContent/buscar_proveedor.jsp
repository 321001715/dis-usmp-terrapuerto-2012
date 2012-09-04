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
		alert("Debe llenar alguna condición de búsqueda.");
		document.buscar.ruc.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form name="buscar" action="ServletProveedor" method="post" onsubmit="return validar()">
	<input type="hidden" name="tipo" value="filtro">
	<input type="hidden" name="destino" value="<%=Constantes.MANTENER_PROVEEDOR%>">
	RUC <input type="text" name="ruc" maxlength="9">
	Raz&oacute;n social <input type="text" name="razSocial">
	<input type="submit" value="Buscar">
</form>

</body>
</html>